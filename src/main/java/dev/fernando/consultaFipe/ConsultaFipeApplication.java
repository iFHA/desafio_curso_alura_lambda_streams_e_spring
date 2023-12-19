package dev.fernando.consultaFipe;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.fernando.consultaFipe.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsultaFipeApplication {
	@Autowired
	private Principal principal;
	public static void main(String[] args) {
		SpringApplication.run(ConsultaFipeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return (args) -> {
			this.principal.exibeMenu();
		};
	}

}
