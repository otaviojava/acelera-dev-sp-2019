package org.acelera.saopaulo.soccer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Jogador jogador = Jogador.builder().withNome("Neymar")
                .withCidade("Salvador")
                .withPais("Brasil").withGols(10)
                .withPosicao(Posicao.ATAQUE).build();

        bahia.adicionar(jogador);
        Assertions.assertEquals(1, bahia.total());
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            bahia.getJogadores().clear();
        });

    }

}