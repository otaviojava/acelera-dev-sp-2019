package org.acelera.saopaulo.soccer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;

@Document("times")
public class Time implements Serializable
{
    private static final long serialVersionUID = 3393869211696350401L;

    @Id
    @JsonIgnore
    private String id;

    private final String nome;
    private final List<Jogador> jogadores;

    private Time(String nome)
    {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    @JsonCreator
    public static Time of(@JsonProperty("nome") String nome)
    {
        return new Time(requireNonNull(nome, "nome eh obrigatorio"));
    }

    public String getNome()
    {
        return nome;
    }

    public List<Jogador> getJogadores()
    {
        return Collections.unmodifiableList(jogadores);
    }

    @JsonIgnore
    public void adicionar(Jogador jogador)
    {
        jogadores.add(jogador);
    }

    @JsonIgnore
    public int total()
    {
        return jogadores.size();
    }

    @JsonIgnore
    public List<Jogador> getFantastico()
    {
        return jogadores.stream()
                .filter(j -> j.getGols() >= 3)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public Map<Posicao, List<Jogador>> getJogadorByPosicao()
    {
        return jogadores.stream()
                .collect(groupingBy(Jogador::getPosicao));
    }

    @JsonIgnore
    public Jogador getArtilheiro()
    {
        Comparator<Jogador> maiorGols = Comparator.comparing(Jogador::getGols);
        Comparator<Jogador> peloNome = Comparator.comparing(Jogador::getNome);
        Optional<Jogador> artilheiro = jogadores.stream()
                .max(maiorGols.thenComparing(peloNome));
        return artilheiro
                .orElseThrow(() -> new IllegalStateException("Sempre deve ter um artilheiro no time"));

    }

    @JsonIgnore
    public List<Jogador> getJogadoresOrderByGols()
    {
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getGols).reversed())
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public boolean removeJogador(String nome)
    {
        return jogadores.removeIf(j -> j.getNome().equals(nome));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Time [nome=").append(nome).append(", jogadores=").append(jogadores).append("]");
        return builder.toString();
    }
}
