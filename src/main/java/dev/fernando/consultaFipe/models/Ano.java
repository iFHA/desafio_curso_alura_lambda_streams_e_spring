package dev.fernando.consultaFipe.models;

import java.util.List;

public class Ano {
    private final String codigo;
    private final Integer ano;
    private final String nome;

    public Ano(String codigo, Integer ano, String nome) {
        this.codigo = codigo;
        this.ano = ano;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Ano{" +
                "ano=" + ano +
                '}';
    }
}
