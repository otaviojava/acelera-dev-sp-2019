package org.acelera.saopaulo.spring;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends PagingAndSortingRepository<Animal, String> {
}
