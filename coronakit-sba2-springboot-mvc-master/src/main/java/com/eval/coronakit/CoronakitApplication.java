package com.eval.coronakit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(" com.eval.coronakit.*")
public class CoronakitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronakitApplication.class, args);
		
	}

}
