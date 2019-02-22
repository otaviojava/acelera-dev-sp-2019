package br.com.codenation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiadaServiceImpl implements PiadasService{

    @Autowired
    PerguntasRespostasRepository perguntasRespostasrepository;

    @Autowired
    TrocadilhoRepository trocadilhoRepository;

    @Override
    public PerguntaResposta getPerguntasRespostasRandom() {
        Long count = perguntasRespostasrepository.count();
        return perguntasRespostasrepository.findById(randomIndex(count)).orElseThrow(NullPointerException::new);
    }

    @Override
    public Piada getTrocadilhoRandom() {
        Long count = trocadilhoRepository.count();
        return trocadilhoRepository.findById(randomIndex(count)).orElseThrow(NullPointerException::new);
    }

    private Long randomIndex(Long rightLimit) {
        long leftLimit = 1L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return generatedLong;
    }
}
