package com.happysolutions.surveyappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SurveyAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppBackendApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.happysolutions"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
			"Survey API",
			"Sample API for swagger tutorial, look for Question entity for more fine grained doc.",
			"1.0",
			"Free to use",
			new Contact("Harsh Gundecha", "https://in.linkedin.com/in/harsh-gundecha","harsh.gundecha@gmail.com"),
			"API License",
			"",
			Collections.emptyList()
		);
	}
}
