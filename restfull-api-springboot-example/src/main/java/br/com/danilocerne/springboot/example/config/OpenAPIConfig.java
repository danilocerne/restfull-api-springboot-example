package br.com.danilocerne.springboot.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("RESTFull API with Java 18 and Spring Boot 3")
					.version("v1")
					.description("RESTFull API")
					.termsOfService("https://danilocerne.com/blog")
					.license(
						new License()
							.name("Apache 2.0")
							.url("https://danilocerne.com/blog")
						)
					);
				
	}
}
