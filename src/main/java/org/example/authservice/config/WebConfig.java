package org.example.authservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Barcha so'rovlar uchun
                .allowedOrigins("http://localhost:3001", "http://localhost:3000", "http://159.65.119.240:8080") // Faqat belgilangan manzilardan kelgan so'rovlar
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Qabul qilinadigan HTTP usullari
                .allowedHeaders("*"); // Qabul qilinadigan sarlavhalar
    }
}