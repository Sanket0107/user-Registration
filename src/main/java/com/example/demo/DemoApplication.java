package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	final String msg = "User Registration Api";

	@Bean
	OpenAPI openAPI() {

		return new OpenAPI().addSecurityItem(new SecurityRequirement())
				.components(new Components())
				.info(new Info().title("User Registration REST API").description(msg).version("1.0")
						.license(new License().name("License of API").url("/swagger-ui/index.html")));
	}

	
}
