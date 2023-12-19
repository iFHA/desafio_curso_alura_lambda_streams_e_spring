package dev.fernando.consultaFipe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnoDTO(String codigo, String nome) {
}
