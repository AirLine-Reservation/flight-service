package edu.miu.cs.cs544.flightservice.repository;

import edu.miu.cs.cs544.flightservice.domain.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirPortRepository extends JpaRepository<AirPort,Integer> {
}
