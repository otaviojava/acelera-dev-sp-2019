package com.jetherrodrigues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.jetherrodrigues.domain"
})
@ComponentScan(basePackages = {
		"com.jetherrodrigues.*"
})
public class ControleEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleEstoqueApplication.class, args);
	}

}
