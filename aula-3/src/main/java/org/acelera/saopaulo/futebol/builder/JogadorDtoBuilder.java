package org.acelera.saopaulo.futebol.builder;

import org.acelera.saopaulo.futebol.dto.JogadorDto;
import org.acelera.saopaulo.futebol.entity.Jogador;

public class JogadorDtoBuilder {

    public static JogadorDto buildFromEntity(Jogador jogador) {
        JogadorDto jogadorDto = new JogadorDto();
        jogadorDto.setNome(jogador.getNome());
        jogadorDto.setCidade(jogador.getCidade());
        jogadorDto.setPais(jogador.getPais());
        jogadorDto.setGols(jogador.getGols());
        jogadorDto.setPosicao(jogador.getPosicao());
        jogadorDto.setTime(jogador.getTime().getNome());
        return jogadorDto;
    }
}
