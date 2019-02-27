package org.acelera.saopaulo.soccer.repository;

import org.acelera.saopaulo.soccer.entity.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<Time, String> {
}
