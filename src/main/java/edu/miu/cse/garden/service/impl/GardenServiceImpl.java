package edu.miu.cse.garden.service.impl;

import edu.miu.cse.garden.domain.Garden;
import edu.miu.cse.garden.repository.GardenRepository;
import edu.miu.cse.garden.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {
    private final GardenRepository gardenRepository;
    @Override
    public Optional<Garden> save(Garden garden) {
        return Optional.of(gardenRepository.save(garden));
    }

    @Override
    public List<Garden> findAll() {
        return gardenRepository.findAll();
    }

    @Override
    public Optional<Garden> findByGardenName(String name) {
        return Optional.of(gardenRepository.findByName(name).get());
    }

    @Override
    public void deleteByGardenName(String name) {
        gardenRepository.deleteByName(name);
    }


    @Override
    public Optional<Garden> update(Garden garden) {
        return Optional.of(gardenRepository.save(garden));
    }

    @Override
    public void deleteGarden(Integer gardenId) {
        gardenRepository.deleteById(gardenId);
    }
}
