package org.acelera.saopaulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping(value = "/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping(value = "/{id}/total", produces = "application/json")
    public int total(@PathVariable Long id){
        return timeService.getTotalDeJogadores(id);
    }

    @GetMapping(value = "/{id}/fantastico", produces = "application/json")
    public List<Jogador> fantastico(@PathVariable Long id){
        return timeService.getJogadoresFantastico(id);
    }

    @GetMapping(value = "/{id}/posicao", produces = "application/json")
    public Map<Posicao, List<Jogador>> posicao(@PathVariable Long id){
        return timeService.getJogadoresPorPosicao(id);
    }

    @GetMapping(value = "/{id}/posicao/{posicao}", produces = "application/json")
    public Map<Posicao, List<Jogador>> posicao(@PathVariable Long id, @PathVariable Posicao posicao){
        return timeService.getJogadoresPorPosicao(id, posicao);
    }

    @GetMapping(value = "/{id}/artilheiro", produces = "application/json")
    public Jogador artilheiro(@PathVariable Long id){
        return timeService.getArtilheiro(id);
    }

    @GetMapping(value = "/{id}/bygols", produces = "application/json")
    public List<Jogador> byGols(@PathVariable Long id){
        return timeService.getJogadoresOrdenadosPorGols(id);
    }
}
