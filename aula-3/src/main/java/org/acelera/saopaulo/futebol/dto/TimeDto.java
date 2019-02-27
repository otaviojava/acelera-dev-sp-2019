package org.acelera.saopaulo.futebol.dto;

import java.util.ArrayList;
import java.util.List;

public class TimeDto {

    private String nome;

    private List<JogadorDto> jogadores = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<JogadorDto> getJogadores() {
        return jogadores;
    }

    public void adicionaJogador(JogadorDto jogador) {
        jogadores.add(jogador);
    }

}
