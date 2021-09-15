package com.benz.consumerfacing.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.benz.*")
@EntityScan(basePackages = { "com.benz.*" })
public class ProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessApplication.class, args);
	}

}
