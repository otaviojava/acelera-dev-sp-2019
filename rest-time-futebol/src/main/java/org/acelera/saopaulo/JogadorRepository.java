package org.acelera.saopaulo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "jogadores", path = "jogadores")
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
}
