package edu.miu.cse.garden.service;

import edu.miu.cse.garden.domain.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    Optional<Plant> addPlant(Plant plant);
    Optional<Plant> getPlantByName(String plantName);
    List<Plant> getAllPlants();
    List<Plant> getAllPlantsWithSortedByDate();
    void deletePlantByName(String plantName);
    Optional<Plant> updatePlant(Plant plant);
    void deletePlant(Integer id);
}
