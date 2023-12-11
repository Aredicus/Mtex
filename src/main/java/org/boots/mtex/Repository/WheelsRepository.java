package org.boots.mtex.Repository;

import org.boots.mtex.Entity.Wheels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface WheelsRepository extends JpaRepository<Wheels, Long> {

    Wheels findBySize(String size);
}
