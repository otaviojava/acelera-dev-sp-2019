package org.acelera.saopaulo.model;

public class Jogador {

    private String nome;

    private PosicaoJogadorEnum posicaoJogador;

    private String cidade;

    private String pais;

    private int totalGols;

    Jogador(String nome, PosicaoJogadorEnum posicaoJogador, String cidade, String pais, int totalGols) {
        this.nome = nome;
        this.posicaoJogador = posicaoJogador;
        this.cidade = cidade;
        this.pais = pais;
        this.totalGols = totalGols;
    }

    public String getNome() {
        return nome;
    }

    public PosicaoJogadorEnum getPosicaoJogador() {
        return posicaoJogador;
    }

    public int getTotalGols() {
        return totalGols;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public void fezGol() {
        totalGols++;
    }

    public static JogadorBuilder builder() {
        return new JogadorBuilder();
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", posicaoJogador=" + posicaoJogador +
                ", totalGols=" + totalGols +
                '}';
    }
}
