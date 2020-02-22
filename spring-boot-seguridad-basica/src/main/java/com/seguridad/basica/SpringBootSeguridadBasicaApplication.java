package com.seguridad.basica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude =  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class SpringBootSeguridadBasicaApplication {

	//
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSeguridadBasicaApplication.class, args);
	}

}
