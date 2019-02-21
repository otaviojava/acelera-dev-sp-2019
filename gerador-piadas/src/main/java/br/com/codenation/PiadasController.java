package br.com.codenation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piadas")
public class PiadasController {
    @Autowired
    private PiadasService service;

    @GetMapping("/perguntas-respostas")
    public ResponseEntity<Piada> getPiadaPerguntaResposta(){
        return ResponseEntity.ok(service.getPerguntasRespostasRandom());
    }

    @GetMapping("/trocadilhos")
    public ResponseEntity<Piada> getTrocadilho(){
        return ResponseEntity.ok(service.getTrocadilhoRandom());
    }
}
