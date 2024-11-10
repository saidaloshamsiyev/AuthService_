package org.example.authservice.config;


import org.example.authservice.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final String[] WHITE_LIST = {"/api/auth/login",
            "/api/auth/register",
            "/api/auth/swagger-ui/**",
            "/api/auth/v3/api-docs/**",
            "/v3/api-docs/",
            "/swagger-ui/",
            "/swagger-ui.html"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // CORS ni yoqing
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(WHITE_LIST).permitAll()  // Agar sizda maxsus ruxsatlar bo'lsa
                                .anyRequest().authenticated()
                )
                .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*"); // All origins are allowed
        config.addAllowedHeader("*"); // All headers are allowed
        config.addAllowedMethod("*"); // All HTTP methods are allowed

        source.registerCorsConfiguration("/**", config); // Apply CORS configuration to all paths
        return new CorsFilter(source);
    }
}


