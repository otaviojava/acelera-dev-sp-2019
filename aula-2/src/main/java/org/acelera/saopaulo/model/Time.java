package org.acelera.saopaulo.model;

import java.util.*;
import java.util.stream.Collectors;

public class Time {

    private final String nome;

    private final List<Jogador> jogadores;

    private Time(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public static Time of(String nome) {
        return new Time(Objects.requireNonNull(nome, "Nome obrigatorio"));
    }

    public void adicionaJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        if (jogadores == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(jogadores);
    }

    public int total() {
        return jogadores.size();
    }

    public List<Jogador> getGolNoFantastico() {
        return jogadores.stream().filter(j -> 3 <= j.getTotalGols()).collect(Collectors.toList());
    }

    public List<Jogador> getArtilheiro() {
        return jogadores.stream().
                filter(j -> jogadores.stream().
                    max(Comparator.comparing(Jogador::getTotalGols))
                    .orElseThrow(() -> new IllegalStateException("Nenhum artilheiro encontrado"))
                        .getTotalGols() == j.getTotalGols())
                .collect(Collectors.toList());
    }

    public List<Jogador> ordenaJogadoresPorGol() {
        return jogadores.stream().sorted(Comparator.comparing(Jogador::getTotalGols).reversed()).collect(Collectors.toList());
    }

    public List<Jogador> agrupaPosicao(PosicaoJogadorEnum posicao) {
        return jogadores.stream().filter(j -> posicao.equals(j.getPosicaoJogador())).collect(Collectors.toList());
    }
}
