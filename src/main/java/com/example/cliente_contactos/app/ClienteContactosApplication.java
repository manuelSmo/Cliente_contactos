package com.example.cliente_contactos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.cliente_contactos.controller"})
public class ClienteContactosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteContactosApplication.class, args);
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}
}
