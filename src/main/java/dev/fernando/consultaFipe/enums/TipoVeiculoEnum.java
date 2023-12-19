package dev.fernando.consultaFipe.enums;

import java.util.Arrays;

public enum TipoVeiculoEnum {
    CARRO("carros"), MOTO("motos"), CAMINHAO("caminhoes");
    private final String value;
    private TipoVeiculoEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public static TipoVeiculoEnum fromString(String tipo) {
        return Arrays
                .stream(TipoVeiculoEnum.values())
                .filter(t->t.getValue().equalsIgnoreCase(tipo))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
