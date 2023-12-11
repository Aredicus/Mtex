package org.boots.mtex.Repository;

import jakarta.transaction.Transactional;
import org.boots.mtex.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into cars(id, wheels_id, corpus_id, name) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertCar(Long id, Long wheels_id, Long corpus_id, String name);
}
