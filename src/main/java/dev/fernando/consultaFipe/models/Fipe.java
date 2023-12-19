package dev.fernando.consultaFipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Fipe(
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer ano,
        @JsonAlias("Valor") String valor
) {
    public Double getValor() {
        return Double.parseDouble(this.valor()
                .replace(".", "")
                .replace(",", ".")
                .replace("R$ ", ""));
    }
}
