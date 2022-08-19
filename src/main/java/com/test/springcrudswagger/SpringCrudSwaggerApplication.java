package com.test.springcrudswagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Service API", version = "2.0", description = "Service API Information"))
public class SpringCrudSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudSwaggerApplication.class, args);
	}

}
