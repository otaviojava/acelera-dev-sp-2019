package br.com.codenation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PiadasIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getPerguntasRespostas() throws Exception {
        ResponseEntity<PerguntaResposta> response = restTemplate.getForEntity("/piadas/perguntas-respostas", PerguntaResposta.class);
        Piada piada = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(piada);
    }

    @Test
    public void getTrocadilhos() throws Exception {
        ResponseEntity<Trocadilho> response = restTemplate.getForEntity("/piadas/trocadilhos", Trocadilho.class);
        Trocadilho piada = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(piada);
    }
}
