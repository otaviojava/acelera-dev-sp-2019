package org.acelera.saopaulo.spring;

public class Motorista {

    private final String nome;

    public Motorista(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Motorista{");
        sb.append("nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
