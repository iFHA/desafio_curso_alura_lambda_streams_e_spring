package dev.fernando.consultaFipe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarcaDTO(String codigo, String nome) {
}
