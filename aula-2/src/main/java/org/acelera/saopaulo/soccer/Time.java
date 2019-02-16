package org.acelera.saopaulo.soccer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;

public class Time {

    private final String nome;

    private final List<Jogador> jogadores;

    private Time(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public List<Jogador> getJogadores() {
        return Collections.unmodifiableList(jogadores);
    }

    public void adicionar(Jogador jogador) {
        jogadores.add(jogador);
    }

    public static Time of(String nome) {
        return new Time(requireNonNull(nome, "nome eh obrigatorio"));
    }

    public int total() {
        return jogadores.size();
    }


    public List<Jogador> getFantastico() {
        return jogadores.stream()
                .filter(j -> j.getGols()>= 3)
                .collect(Collectors.toList());
    }

    public Map<Posicao, List<Jogador>> getJogadorByPosicao() {
        return jogadores.stream()
                .collect(groupingBy(Jogador::getPosicao));
    }
}
