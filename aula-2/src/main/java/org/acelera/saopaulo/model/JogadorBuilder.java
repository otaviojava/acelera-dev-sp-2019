package org.acelera.saopaulo.model;

import java.util.Objects;

public class JogadorBuilder {
    private String nome;
    private PosicaoJogadorEnum posicaoJogador;
    private String cidade;
    private String pais;
    private int totalGols;

    public JogadorBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public JogadorBuilder setPosicaoJogador(PosicaoJogadorEnum posicaoJogador) {
        this.posicaoJogador = posicaoJogador;
        return this;
    }

    public JogadorBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public JogadorBuilder setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public JogadorBuilder setTotalGols(int totalGols) {
        this.totalGols = totalGols;
        return this;
    }

    public Jogador build() {
        Objects.requireNonNull(nome, "O nome nao pode ser nulo");
        return new Jogador(nome, posicaoJogador, cidade, pais, totalGols);
    }
}