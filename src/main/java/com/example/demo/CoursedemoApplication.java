package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
@EntityScan(basePackages = "com.example.demo.entity")
public class CoursedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursedemoApplication.class, args);
	}

}
