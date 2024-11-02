//package org.example.authservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import java.util.List;
//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfiguration = getCorsConfiguration();
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/api/**", corsConfiguration);
//        source.registerCorsConfiguration("/v3/api-docs/**", corsConfiguration); // Swagger UI uchun
//        source.registerCorsConfiguration("/swagger-ui/**", corsConfiguration); // Swagger UI uchun
//        return source;
//    }
//
//    private static CorsConfiguration getCorsConfiguration() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedOriginPatterns(List.of("http://localhost:3000", "http://159.65.119.240:8080", "http://localhost:3001"));
//        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept"));
//        corsConfiguration.setExposedHeaders(List.of("Authorization"));
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//}