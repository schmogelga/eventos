package com.webapp.projeto;

import com.webapp.projeto.application.security.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjetoApplication.class, args);
	}

}
