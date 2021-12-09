package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//Todos los paquetes tienen que estar dentro de com.example.demo o no funcionara
	//Un ejemplo seria com.example.demo.miPaquete
}
