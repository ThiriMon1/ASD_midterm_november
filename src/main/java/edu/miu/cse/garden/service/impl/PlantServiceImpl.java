package edu.miu.cse.garden.service.impl;

import edu.miu.cse.garden.domain.Plant;
import edu.miu.cse.garden.repository.PlantRepository;
import edu.miu.cse.garden.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    @Override
    public Optional<Plant> addPlant(Plant plant) {
        return Optional.of(plantRepository.save(plant));
    }

    @Override
    public Optional<Plant> getPlantByName(String plantName) {
        return Optional.of(plantRepository.findByName(plantName).get());
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Plant> getAllPlantsWithSortedByDate() {
        return plantRepository.findAll(Sort.by(Sort.Direction.ASC, "plantDate"));
    }


    @Override
    public void deletePlantByName(String plantName) {
        plantRepository.deleteByName(plantName);
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        return Optional.of(plantRepository.save(plant));
    }

    @Override
    public void deletePlant(Integer plantId) {
        plantRepository.deleteById(plantId);
    }
}
