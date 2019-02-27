package org.acelera.saopaulo.futebol.service;

import org.acelera.saopaulo.futebol.Posicao;
import org.acelera.saopaulo.futebol.builder.JogadorDtoBuilder;
import org.acelera.saopaulo.futebol.builder.TimeDtoBuilder;
import org.acelera.saopaulo.futebol.dto.JogadorDto;
import org.acelera.saopaulo.futebol.dto.TimeDto;
import org.acelera.saopaulo.futebol.entity.Time;
import org.acelera.saopaulo.futebol.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    private static String TIME_NAO_ENCONTRADO = "Time nao encontrado";

    public void criaTime(TimeDto timeDto) {
        Time time = new Time();
        time.setNome(timeDto.getNome());
        timeRepository.save(time);
    }

    public TimeDto getTime(final String nome) {
        return TimeDtoBuilder.buildFromEntity(
                timeRepository.findById(nome).orElseThrow(() -> new EntityNotFoundException(TIME_NAO_ENCONTRADO))
        );
    }

    public TimeDto atualizaTime(String nome, TimeDto timeDto) {
        Time time = timeRepository.findById(nome).orElseThrow(() -> new EntityNotFoundException(TIME_NAO_ENCONTRADO));
        time.setNome(timeDto.getNome());
        return TimeDtoBuilder.buildFromEntity(timeRepository.save(time));
    }

    public List<TimeDto> getTimes() {
        List<TimeDto> times = new ArrayList<>();
        timeRepository.findAll().forEach(t -> times.add(TimeDtoBuilder.buildFromEntity(t)));
        return times;
    }

    public void removeTime(String nome) {
        timeRepository.deleteById(nome);
    }

    public List<JogadorDto> getFantastico(String nomeTime) {
        Time time = timeRepository.findById(nomeTime).orElseThrow(() -> new EntityNotFoundException(TIME_NAO_ENCONTRADO));
        return time.getJogadores().stream()
                .filter(j -> 3 <= j.getGols())
                .collect(Collectors.toList()).stream()
                    .map(JogadorDtoBuilder::buildFromEntity)
                    .collect(Collectors.toList());
    }


    public Map<Posicao, List<JogadorDto>> getJogadorByPosicao(String nomeTime) {
        TimeDto time = getTime(nomeTime);
        return time.getJogadores().stream()
                .collect(groupingBy(JogadorDto::getPosicao));
    }

    public List<JogadorDto> getArtilheiro(String nomeTime) {
        TimeDto time = getTime(nomeTime);
        int maxGols = time.getJogadores().stream()
                .max(Comparator.comparing(JogadorDto::getGols))
                .orElseThrow(() -> new IllegalStateException("Nenhum artilheiro encontrado"))
                .getGols();

        return time.getJogadores().stream()
                .filter(j ->
                         maxGols == j.getGols()
                ).collect(Collectors.toList());
    }

    public List<JogadorDto> getJogadoresOrdenadoPorGols(String nomeTime) {
        TimeDto time = getTime(nomeTime);
        return time.getJogadores().stream()
                .sorted(Comparator.comparing(JogadorDto::getGols).reversed())
                .collect(Collectors.toList());
    }
}
