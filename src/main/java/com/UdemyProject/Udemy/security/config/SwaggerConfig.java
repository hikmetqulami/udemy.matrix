package com.UdemyProject.Udemy.security.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@OpenAPIDefinition(info = @Info(title = "SpringBootSwagger",
        version = "0.0.1", description = "Created for website Udemy.com"))
public class SwaggerConfig {

}
