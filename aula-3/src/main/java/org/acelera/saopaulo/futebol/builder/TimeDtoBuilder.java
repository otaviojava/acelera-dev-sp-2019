package org.acelera.saopaulo.futebol.builder;

import org.acelera.saopaulo.futebol.dto.TimeDto;
import org.acelera.saopaulo.futebol.entity.Time;

public class TimeDtoBuilder {

    public static TimeDto buildFromEntity(Time time) {
        TimeDto timeDto = new TimeDto();
        timeDto.setNome(time.getNome());
        time.getJogadores().forEach(jogador ->
                timeDto.adicionaJogador(JogadorDtoBuilder.buildFromEntity(jogador))
        );
        return timeDto;
    }
}
