package org.acelera.saopaulo.futebol.entity;

import javax.persistence.*;
import java.util.*;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;

@Entity
public class Time {

    @Id
    private String nome;

    @OneToMany(mappedBy = "time", targetEntity = Jogador.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jogador> jogadores = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

}
