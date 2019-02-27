package org.acelera.saopaulo.soccer.controller;

import org.acelera.saopaulo.soccer.Posicao;
import org.acelera.saopaulo.soccer.dto.JogadorDto;
import org.acelera.saopaulo.soccer.dto.TimeDto;
import org.acelera.saopaulo.soccer.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    public void criaTime(@RequestBody TimeDto timeDto) {
        timeService.criaTime(timeDto);
    }

    @PutMapping("/{nome}")
    public TimeDto atualizaTime(@PathVariable String nome, @RequestBody TimeDto timeDto) {
        return timeService.atualizaTime(nome, timeDto);
    }

    @GetMapping("/{nome}")
    public TimeDto buscaTIme(@PathVariable String nome) {
        return timeService.getTime(nome);
    }

    @DeleteMapping("/{nome}")
    public void removeTime(@PathVariable String nome) {
        timeService.removeTime(nome);
    }

    @GetMapping(value = "/all")
    public List<TimeDto> buscaTimes() {
        return timeService.getTimes();
    }

    @GetMapping("/fantastico/{nome}")
    public List<JogadorDto> getFantastico(@PathVariable String nome) {
        return timeService.getFantastico(nome);
    }

    @GetMapping("/{nome}/posicao")
    public Map<Posicao, List<JogadorDto>> buscaPorPosicao(@PathVariable String nome) {
        return timeService.getJogadorByPosicao(nome);
    }

    @GetMapping("/{nome}/artilheiro")
    public List<JogadorDto> buscaArtilheiro(@PathVariable String nome) {
        return timeService.getArtilheiro(nome);
    }

    @GetMapping("/{nome}/ordenado-gol")
    public List<JogadorDto> buscaOrdenadoGol(@PathVariable String nome) {
        return timeService.getJogadoresOrdenadoPorGols(nome);
    }
}
