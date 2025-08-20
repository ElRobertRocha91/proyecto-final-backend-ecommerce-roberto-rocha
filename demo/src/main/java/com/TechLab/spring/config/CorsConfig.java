package com.TechLab.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Habilito todos los endpoints
                        .allowedOrigins("http://localhost:5500") // permite todos los origenes
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // metodos permitidos
                        .allowedHeaders("*");
            }
        };
    }
}
