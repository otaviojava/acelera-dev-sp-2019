package org.acelera.saopaulo.soccer.repository;

import org.acelera.saopaulo.soccer.entity.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, String> {
}
