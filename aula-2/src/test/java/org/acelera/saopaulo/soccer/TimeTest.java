package org.acelera.saopaulo.soccer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

class TimeTest {


    @Test
    public void deveCriarTime() {
        Assertions.assertThrows(NullPointerException.class, () -> Time.of(null));
        Time bahia = Time.of("Bahia");
        Assertions.assertNotNull(bahia);
    }

    @Test
    public void deveAdicionarJogador() {
        Time bahia = Time.of("Bahia");

        Jogador jogador = Mockito.mock(Jogador.class);
        Mockito.when(jogador.getNome()).thenReturn("ahha pegadinho do Malandro");

        bahia.adicionar(jogador);

        Assertions.assertEquals(1, bahia.total());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            bahia.getJogadores().clear();
        });
    }


    @Test
    public void deveRetornarFantastico() {
        Time bahia = Time.of("Bahia");

        Jogador bobo = mock("Bobo", 3);
        Jogador lima = mock("Lima", 5);;
        Jogador neymar = mock("Neymar", 1);

        bahia.adicionar(bobo);
        bahia.adicionar(lima);
        bahia.adicionar(neymar);

        List<Jogador> fantastico = bahia.getFantastico();
        String fanstastiqueiros = fantastico.stream()
                .map(Jogador::getNome)
                .sorted()
                .collect(joining(","));

        Assertions.assertEquals(2, fantastico.size());
        Assertions.assertEquals("Bobo,Lima", fanstastiqueiros);

    }

    private Jogador mock(String nome, int gols) {
        Jogador jogador = Mockito.mock(Jogador.class);
        Mockito.when(jogador.getNome()).thenReturn(nome);
        Mockito.when(jogador.getGols()).thenReturn(gols);
        return jogador;
    }

}