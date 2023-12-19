package dev.fernando.consultaFipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.fernando.consultaFipe.models.Modelo;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloDTO(@JsonAlias("modelos") List<Modelo> modelos) {
}
