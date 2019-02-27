package org.acelera.saopaulo.soccer.builder;

import org.acelera.saopaulo.soccer.dto.TimeDto;
import org.acelera.saopaulo.soccer.entity.Time;

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
