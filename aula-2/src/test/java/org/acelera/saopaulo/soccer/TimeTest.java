package org.acelera.saopaulo.soccer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.acelera.saopaulo.soccer.Posicao.ATAQUE;
import static org.acelera.saopaulo.soccer.Posicao.DEFESA;
import static org.acelera.saopaulo.soccer.Posicao.GOLEIRO;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void deveAgruparPorPosicao() {
        Time bahia = Time.of("Bahia");

        Jogador bobo = mock("Bobo", 3, DEFESA);
        Jogador jorge = mock("Jorge", 3, DEFESA);
        Jogador jose = mock("jose", 3, DEFESA);
        Jogador lima = mock("Lima", 5, ATAQUE);
        Jogador neymar = mock("Neymar", 1, ATAQUE);
        Jogador tafarel = mock("Tafarel", 0, GOLEIRO);

        bahia.adicionar(bobo);
        bahia.adicionar(jorge);
        bahia.adicionar(jose);
        bahia.adicionar(lima);
        bahia.adicionar(neymar);
        bahia.adicionar(tafarel);

        Map<Posicao, List<Jogador>> jogaborbyPosicao = bahia.getJogadorByPosicao();

        assertEquals(1, jogaborbyPosicao.get(GOLEIRO).size());
        assertEquals(3, jogaborbyPosicao.get(DEFESA).size());
        assertEquals(2, jogaborbyPosicao.get(ATAQUE).size());

        assertEquals("Tafarel", convertToName(jogaborbyPosicao.get(GOLEIRO)));
        assertEquals("Bobo,Jorge,jose", convertToName(jogaborbyPosicao.get(DEFESA)));
        assertEquals("Lima,Neymar", convertToName(jogaborbyPosicao.get(ATAQUE)));


    }

    private String convertToName(List<Jogador> jogadores) {
        return jogadores.stream().map(Jogador::getNome).collect(Collectors.joining(","));
    }

    private Jogador mock(String nome, int gols) {
        return mock(nome, gols, ATAQUE);
    }

    private Jogador mock(String nome, int gols, Posicao posicao) {
        Jogador jogador = Mockito.mock(Jogador.class);
        Mockito.when(jogador.getNome()).thenReturn(nome);
        Mockito.when(jogador.getGols()).thenReturn(gols);
        Mockito.when(jogador.getPosicao()).thenReturn(posicao);
        return jogador;
    }

}