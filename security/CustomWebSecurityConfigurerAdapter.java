package com.conurets.parking_kiosk.security;

import com.conurets.parking_kiosk.base.util.PKHelper;
import com.conurets.parking_kiosk.security.exception.CustomAccessDeniedHandler;
import com.conurets.parking_kiosk.security.exception.CustomAuthenticationEntryPoint;
import com.conurets.parking_kiosk.security.filter.CustomAuthenticationFilter;
import com.conurets.parking_kiosk.security.service.CustomUserDetailsService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
@Configuration
@EnableWebSecurity
public abstract class CustomWebSecurityConfigurerAdapter {
    private final String[] apiUrl;
    private final String[] resourceUrl;
    private final String[] websocketUrl;

    @Autowired
    private CustomUserDetailsService authenticationService;
    @Autowired
    private CustomAuthenticationFilter jwtTokenAuthenticationFilter;
    @Autowired
    private CustomAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private CustomAccessDeniedHandler jwtAccessDeniedHandler;

    public CustomWebSecurityConfigurerAdapter(String[] apiUrl, String[] resourceUrl,
                                              String[] websocketUrl) {
        this.apiUrl = apiUrl;
        this.resourceUrl = resourceUrl;
        this.websocketUrl = websocketUrl;
    }

    @PostConstruct
    public void checkConfiguration() {
        PKHelper.checkConfiguration(authenticationService, "authenticationService");
        PKHelper.checkConfiguration(jwtTokenAuthenticationFilter, "jwtTokenAuthenticationFilter");
        PKHelper.checkConfiguration(jwtAuthenticationEntryPoint, "jwtAuthenticationEntryPoint");
        PKHelper.checkConfiguration(jwtAccessDeniedHandler, "jwtAccessDeniedHandler");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authenticationService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .formLogin(formLoginConfigurer -> formLoginConfigurer.disable())
                .headers(headersConfigurer -> headersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(apiUrl).permitAll()
                        .requestMatchers(resourceUrl).permitAll()
                        .requestMatchers(websocketUrl).permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler))
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Use specific origins in production
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
