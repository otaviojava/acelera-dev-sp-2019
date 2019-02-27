package org.acelera.saopaulo.futebol.repository;

import org.acelera.saopaulo.futebol.entity.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, String> {
}
