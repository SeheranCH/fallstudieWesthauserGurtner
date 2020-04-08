package ch.course223.helloworldIvo.config.security;

import ch.course223.helloworldIvo.config.PropertyReader;
import ch.course223.helloworldIvo.domainModells.user.UserService;
import ch.course223.helloworldIvo.domainModells.user.dto.UserMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

// This class handles security concerns
@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    private BCryptPasswordEncoder pwEncoder;

    private PropertyReader propertyReader;

    private Logger errorLogger;

    private Logger logger;

    private UserMapper userMapper;

    @Autowired
    public SecurityConfig(
            UserService userService,
            BCryptPasswordEncoder pwEncoder,
            @Qualifier("webErrorLogger") Logger errorLogger,
            Logger logger,
            UserMapper userMapper
    ) {
        super();
        this.userService = userService;
        this.pwEncoder = pwEncoder;
        this.errorLogger = errorLogger;
        this.logger = logger;
        this.userMapper = userMapper;
    }

    // This method specifies the AuthenticationBuilder and the PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(pwEncoder);
    }

    // This method exposes the AuthenticationManagerBean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // This bean sets various CORS (Cross Origin Resource-Sharing) configurations,
    // such as which http requests are allowed, if credentials are allowed etc
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        // This logic ensures that the configurations are valid on all URLs
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    //This method is the main configuration for this application
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        propertyReader = new PropertyReader("jwt.properties");

        http.cors().and().csrf().disable().
                authorizeRequests()
                // These end points are permitted without login
                .antMatchers("/login", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
                        "/webjars/**", "/swagger.yaml", "/**")
                .permitAll()
                .anyRequest().authenticated().and()
                // From here on out all requests will be filtered by the authorization of the authenticated user
                .addFilterAfter(
                        // The filter itself
                        new JWTAuthenticationFilter(
                                new AntPathRequestMatcher("/login", "POST"),
                                authenticationManagerBean(),
                                propertyReader,
                                logger,
                                userMapper)
                        , UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(
                        new JWTAuthorizationFilter(userService, propertyReader, errorLogger::warn), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                // This line ensures that this application is indeed stateless
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}

