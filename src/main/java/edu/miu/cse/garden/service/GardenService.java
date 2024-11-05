package edu.miu.cse.garden.service;

import edu.miu.cse.garden.domain.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    Optional<Garden> save(Garden garden);
    List<Garden> findAll();
    Optional<Garden> findByGardenName(String gardenName);
    void deleteByGardenName(String gardenName);
    Optional<Garden> update(Garden garden);
    void deleteGarden(Integer gardenId);
}
