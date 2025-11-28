package com.back.SpringValidationTest_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringValidationTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationTest1Application.class, args);
	}

}
