package org.acelera.saopaulo.futebol.entity;

import org.acelera.saopaulo.futebol.Posicao;

import javax.persistence.*;

@Entity
public class Jogador {

    @Id
    private String nome;

    @Column
    private String cidade;

    @Column
    private String pais;

    @Column
    private Posicao posicao;

    @Column
    private int gols;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time")
    private Time time;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
