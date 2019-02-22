package br.com.codenation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocadilhoRepository extends CrudRepository<Trocadilho, Long> {
}
