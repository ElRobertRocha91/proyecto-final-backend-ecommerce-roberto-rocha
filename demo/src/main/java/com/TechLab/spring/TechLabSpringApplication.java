package com.TechLab.spring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TechLabSpringApplication {
	public static void main(String[] args) {
		// Agregando variables de entorno
		Dotenv dotenv = Dotenv.load();
		String dbPassword = dotenv.get("PASSWORD_DATABASE");
		// Validación
		if(dbPassword != null) {
			System.setProperty("PASSWORD_DATABASE", dbPassword);
		} else {
			System.out.println("La clave de acceso de .env no esta");
		}

		SpringApplication.run(TechLabSpringApplication.class, args);
	}

}
