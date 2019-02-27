package org.acelera.saopaulo;


import org.acelera.saopaulo.model.Jogador;
import org.acelera.saopaulo.model.Time;
import org.acelera.saopaulo.util.Inicializador;
import org.acelera.saopaulo.model.PosicaoJogadorEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class JogadorTest {

    @Test
    public void verificaArtilheiro() {
        Time time = Inicializador.populaDados();
        List<String> nomeJogadores = time.getArtilheiro().stream().map(Jogador::getNome).collect(Collectors.toList());
        Assertions.assertTrue(nomeJogadores.contains("Dudu"));
        Assertions.assertTrue(nomeJogadores.contains("Thiago Santos"));
    }

    @Test
    public void deveRetornarFantastico() {
        Time bahia = Time.of("Bahia");

        Jogador bobo = mock("bobo", 3);
        Jogador lima = mock("lima", 5);
        Jogador neymar = mock("neymar", 1);

        bahia.adicionaJogador(bobo);
        bahia.adicionaJogador(lima);
        bahia.adicionaJogador(neymar);

        List<Jogador> jogadores = bahia.getGolNoFantastico();

        Assertions.assertEquals(2, jogadores.size());
        Assertions.assertTrue(jogadores.stream().map(Jogador::getNome).collect(Collectors.toList()).contains("bobo"));
        Assertions.assertTrue(jogadores.stream().map(Jogador::getNome).collect(Collectors.toList()).contains("lima"));
    }

    @Test
    public void deveRetornarJogadoresOrdenadoMaisGols() {
        Time bahia = Time.of("Bahia");

        Jogador bobo = mock("bobo", 3);
        Jogador lima = mock("lima", 5);
        Jogador neymar = mock("neymar", 1);

        bahia.adicionaJogador(bobo);
        bahia.adicionaJogador(lima);
        bahia.adicionaJogador(neymar);

        List<String> jogadores = bahia.ordenaJogadoresPorGol().stream().map(Jogador::getNome).collect(Collectors.toList());
        List<String> esperado = new ArrayList<>();

        esperado.add("lima");
        esperado.add("bobo");
        esperado.add("neymar");

        Assertions.assertEquals(esperado, jogadores);
    }

    @Test
    public void deveRetornarJogadoresPorPosicao() {
        Time time = Inicializador.populaDados();

        List<String> jogadores = time.agrupaPosicao(PosicaoJogadorEnum.ATAQUE).stream().map(Jogador::getNome).collect(Collectors.toList());
        List<String> esperado = new ArrayList<>();

        Assertions.assertTrue(jogadores.contains("Dudu"));
        Assertions.assertTrue(jogadores.contains("Gustavo Scarpa"));
        Assertions.assertFalse(jogadores.contains("Fernando Prass"));
    }

    private Jogador mock(String nome, int gols) {
        Jogador jogador = Mockito.mock(Jogador.class);
        Mockito.when(jogador.getNome()).thenReturn(nome);
        Mockito.when(jogador.getTotalGols()).thenReturn(gols);

        return jogador;
    }
}
