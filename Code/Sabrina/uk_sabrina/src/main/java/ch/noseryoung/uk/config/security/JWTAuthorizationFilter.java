package ch.noseryoung.uk.config.security;

import ch.noseryoung.uk.config.PropertyReader;
import ch.noseryoung.uk.domainModels.user.UserDetailsImpl;
import ch.noseryoung.uk.domainModels.user.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Consumer;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private UserService userService;

    private PropertyReader propertyReader;

    private Consumer<String> errorLogger;

    public JWTAuthorizationFilter(UserService userService, PropertyReader propertyReader, Consumer<String> errorLogger) {
        this.userService = userService;
        this.propertyReader = propertyReader;
        this.errorLogger = errorLogger;
    }

    // This method sets the authentication
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // This code extracts the header from the request
        String header = request.getHeader(propertyReader.getStringProperty("jwt.header-string"));

        // This code checks if the header is correct and if that is the case sets the authentication
        if (header != null && header.startsWith(propertyReader.getStringProperty("jwt.token-prefix"))) {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(request, header));
        }

        // This code invokes the next part of the chain
        filterChain.doFilter(request, response);

    }

    // This method finds the subject, in this case a user, from the token and gets it's authorities
    private Authentication getAuthentication(HttpServletRequest request, String header) {

        String subject;

        //
        try {
            subject = Jwts.parser()
                    .setSigningKey(propertyReader.getStringProperty("jwt.secret").getBytes())
                    .parseClaimsJws(header.replace(propertyReader.getStringProperty("jwt.token-prefix"), "")).getBody()
                    .getSubject();
        } catch (ExpiredJwtException ex) {
            errorLogger.accept("Expired JWT was given: " + header);
            return null;
        }

        //
        if (subject != null) {
            UserDetailsImpl userDetails = new UserDetailsImpl(userService.findById(subject));
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }

        return null;
    }

}
