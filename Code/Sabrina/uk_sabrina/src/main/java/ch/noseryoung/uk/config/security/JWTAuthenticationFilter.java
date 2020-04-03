package ch.noseryoung.uk.config.security;

import ch.noseryoung.uk.config.PropertyReader;
import ch.noseryoung.uk.domainModels.user.User;
import ch.noseryoung.uk.domainModels.user.UserDetailsImpl;
import ch.noseryoung.uk.domainModels.user.dto.UserDTO;
import ch.noseryoung.uk.domainModels.user.dto.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This class handles authenticating
public class JWTAuthenticationFilter  extends AbstractAuthenticationProcessingFilter {

    private PropertyReader propertyReader;

    private Logger logger;

    private UserMapper userMapper;

    public JWTAuthenticationFilter(
            RequestMatcher requiresAuthenticationRequestMatcher,
            AuthenticationManager authenticationManager,
            PropertyReader propertyReader,
            Logger logger,
            UserMapper userMapper
    ) {
        super(requiresAuthenticationRequestMatcher);
        setAuthenticationManager(authenticationManager);
        this.propertyReader = propertyReader;
        this.logger = logger;
        this.userMapper = userMapper;
    }

    // This method attempts to authenticate the user who is trying to login
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        try {
            // This code reads the received request
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            // This code logs the sent credentials for easier debugging
            logger.debug("Given Credentials from login request:");
            logger.debug("{}", new ObjectMapper().writeValueAsString(user));

            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (IOException e) {
            // If the authentication fails an exception is thrown
            throw new RuntimeException(e);
        }

    }

    // This method is called if the authentication has been successful and creates the JWT
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authentication) throws IOException {
        // This code adds the UserDetailsImpl logic to the authenticated user
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetailsImpl.getUser();
        String subject = user.getUserId();

        // This code builds the JWT
        String token = Jwts.builder().setSubject(subject)
                .setExpiration(
                        new Date(System.currentTimeMillis() + propertyReader.getIntProperty("jwt.expiration-time")))
                .signWith(SignatureAlgorithm.HS512, propertyReader.getStringProperty("jwt.secret").getBytes())
                .compact();

        // This code adds the token to the headers
        response.addHeader(propertyReader.getStringProperty("jwt.header-string"),
                propertyReader.getStringProperty("jwt.token-prefix") + token);

        // This code exposes the Headers
        response.addHeader("Access-Control-Expose-Headers", propertyReader.getStringProperty("jwt.header-string") );

        // This code puts the user into the response body
        UserDTO userDTO = userMapper.toDTO(user);

        // This code turns the DTO into a string
        String userDTOString = new ObjectMapper().writeValueAsString(userDTO);

        // This code writes the DTO, which is a string currently, into the response
        response.getWriter().write(userDTOString);

        // This code converts the payload to a JSON
        response.setContentType("application/json");
    }

}
