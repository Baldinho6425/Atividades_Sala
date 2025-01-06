package br.edu.unoesc.spring.progII;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;

@EntityScan(basePackages = "br.edu.unoesc.spring.progII.model")
@SpringBootApplication
@RestController
public class ProgIiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProgIiApplication.class, args);
	}
}