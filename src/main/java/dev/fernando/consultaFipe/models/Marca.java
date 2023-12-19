package dev.fernando.consultaFipe.models;

public class Marca {
    private final Integer codigo;
    private final String nome;

    public Integer getCodigo() {
        return codigo;
    }

    public Marca(final Integer codigo, final String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
}
