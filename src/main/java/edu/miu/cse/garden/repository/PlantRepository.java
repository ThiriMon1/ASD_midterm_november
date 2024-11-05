package edu.miu.cse.garden.repository;

import edu.miu.cse.garden.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Optional<Plant> findByName(String name);
    void deleteByName(String name);
}
