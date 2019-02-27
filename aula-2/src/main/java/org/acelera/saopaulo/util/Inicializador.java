package org.acelera.saopaulo.util;

import org.acelera.saopaulo.model.Jogador;
import org.acelera.saopaulo.model.PosicaoJogadorEnum;
import org.acelera.saopaulo.model.Time;

public class Inicializador {

    public static Time populaDados() {
        Time palmeiras = Time.of("Palmeiras");

        palmeiras.adicionaJogador(Jogador.builder().setNome("Fernando Prass").setPosicaoJogador(PosicaoJogadorEnum.GOLEIRO).setCidade("Sao paulo").setPais("Brasil").setTotalGols(0).build());
        palmeiras.adicionaJogador(Jogador.builder().setNome("Marcos Rocha").setPosicaoJogador(PosicaoJogadorEnum.DEFESA).setCidade("Sao Paulo").setPais("Brasil").setTotalGols(2).build());
        palmeiras.adicionaJogador(Jogador.builder().setNome("Edu Dracena").setPosicaoJogador(PosicaoJogadorEnum.DEFESA).setCidade("Santos").setPais("Brasil").setTotalGols(1).build());
        palmeiras.adicionaJogador(Jogador.builder().setNome("Thiago Santos").setPosicaoJogador(PosicaoJogadorEnum.DEFESA).setCidade("Sao Paulo").setPais("Brasil").setTotalGols(4).build());
        palmeiras.adicionaJogador(Jogador.builder().setNome("Gustavo Scarpa").setPosicaoJogador(PosicaoJogadorEnum.ATAQUE).setCidade("Rio de Janeiro").setPais("Brasil").setTotalGols(3).build());
        palmeiras.adicionaJogador(Jogador.builder().setNome("Dudu").setPosicaoJogador(PosicaoJogadorEnum.ATAQUE).setCidade("Sao Paulo").setPais("Brasil").setTotalGols(4).build());

        return palmeiras;
    }
}
