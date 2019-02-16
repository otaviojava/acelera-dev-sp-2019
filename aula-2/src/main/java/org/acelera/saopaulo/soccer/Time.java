package org.acelera.saopaulo.soccer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Time {

    private final String nome;

    private final List<Jogador> jogadores;

    private Time(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public List<Jogador> getJogadores() {
        if(jogadores == null) {
            return Collections.emptyList();
        }
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
}
