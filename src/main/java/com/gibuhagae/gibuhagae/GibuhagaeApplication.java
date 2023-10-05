package com.gibuhagae.gibuhagae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan("com.gibuhagae")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GibuhagaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GibuhagaeApplication.class, args);
	}

}
