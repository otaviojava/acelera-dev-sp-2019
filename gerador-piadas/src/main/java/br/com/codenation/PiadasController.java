package br.com.codenation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiadasController {
    @Autowired
    private PiadasService service;

    @GetMapping("/piadas")
    public ResponseEntity<Piada> getPiada(){
        return ResponseEntity.ok(service.getPiadasRandom());
    }
}
