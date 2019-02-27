package org.acelera.saopaulo.futebol.repository;

import org.acelera.saopaulo.futebol.entity.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<Time, String> {
}
