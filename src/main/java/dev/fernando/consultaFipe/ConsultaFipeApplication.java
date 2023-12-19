package dev.fernando.consultaFipe;

import dev.fernando.consultaFipe.converters.AnoConverter;
import dev.fernando.consultaFipe.dto.AnoDTO;
import dev.fernando.consultaFipe.models.Ano;
import dev.fernando.consultaFipe.models.Fipe;
import dev.fernando.consultaFipe.models.Marca;
import dev.fernando.consultaFipe.converters.MarcaConverter;
import dev.fernando.consultaFipe.models.Modelo;
import dev.fernando.consultaFipe.principal.Principal;
import dev.fernando.consultaFipe.services.AnoService;
import dev.fernando.consultaFipe.services.FipeService;
import dev.fernando.consultaFipe.services.MarcaService;
import dev.fernando.consultaFipe.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
