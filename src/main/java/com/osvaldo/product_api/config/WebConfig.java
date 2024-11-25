package com.osvaldo.product_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite requisições de qualquer origem
        registry.addMapping("/api/**")  // Aplica as configurações para a API
                .allowedOrigins("http://127.0.0.1:5500")  // Defina aqui o domínio de onde as requisições são feitas
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
                .allowedHeaders("*");  // Permite qualquer cabeçalho
    }
}