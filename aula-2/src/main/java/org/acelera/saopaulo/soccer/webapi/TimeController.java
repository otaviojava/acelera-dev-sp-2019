package org.acelera.saopaulo.soccer.webapi;

import java.util.List;
import java.util.Map;

import org.acelera.saopaulo.soccer.domain.Jogador;
import org.acelera.saopaulo.soccer.domain.Posicao;
import org.acelera.saopaulo.soccer.domain.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/times")
public class TimeController
{
    private final Time time = Time.of("Bahia");

    @GetMapping(path = "/jogadores/fantasticos")
    public ResponseEntity<List<Jogador>> getFantasticos()
    {
        return ResponseEntity.ok(time.getFantastico());
    }

    @GetMapping(path = "/jogadores/posicoes")
    public ResponseEntity<Map<Posicao, List<Jogador>>> getJogadorByPosicao()
    {
        return ResponseEntity.ok(time.getJogadorByPosicao());
    }

    @GetMapping("/jogadores/artilheiros")
    public ResponseEntity<Jogador> getArtilheiro()
    {
        try
        {
            return ResponseEntity.ok(time.getArtilheiro());
        }
        catch (IllegalStateException e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping(path = "/jogadores/ordenados")
    public ResponseEntity<List<Jogador>> getJogadoresOrderByGols()
    {
        return ResponseEntity.ok(time.getJogadoresOrderByGols());
    }

    @PostMapping(path = "/jogadores")
    public ResponseEntity<Jogador> adicionar(@RequestBody Jogador jogador, UriComponentsBuilder builder)
    {
        time.adicionar(jogador);

        return ResponseEntity.status(HttpStatus.CREATED).body(jogador);
    }

}
