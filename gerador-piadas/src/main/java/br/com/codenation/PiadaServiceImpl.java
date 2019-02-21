package br.com.codenation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PiadaServiceImpl implements PiadasService{

    @Autowired
    PiadasRepository repository;

    @Override
    public Piada getPiadasRandom() {
        Long count = repository.count();
        return repository.findById(randomIndex(count)).get();
    }

    private Long randomIndex(Long rightLimit) {
        long leftLimit = 1L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        return generatedLong;
    }
}
