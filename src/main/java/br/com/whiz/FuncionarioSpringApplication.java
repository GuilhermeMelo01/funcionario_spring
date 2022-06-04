package br.com.whiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FuncionarioSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
