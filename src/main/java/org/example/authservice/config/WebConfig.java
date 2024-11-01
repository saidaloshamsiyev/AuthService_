package org.example.authservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Barcha so'rovlar uchun
                .allowedOrigins("http://localhost:3001","ttp://localhost:3000") // Faqat localhost:3001 manzilidan kelgan so'rovlar
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Qabul qilinadigan HTTP usullari
                .allowedHeaders("*"); // Qabul qilinadigan sarlavhalar
    }
}