package edu.miu.cse.garden;

import edu.miu.cse.garden.domain.Garden;
import edu.miu.cse.garden.domain.Plant;
import edu.miu.cse.garden.service.GardenService;
import edu.miu.cse.garden.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class GardenApplication {
    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(GardenApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Garden garden1 = new Garden("Vegetable Patch",50.0);
            Garden garden2 = new Garden("Herb Garden",20.0);

            gardenService.save(garden1);
            gardenService.save(garden2);

            Plant plant1 = new Plant("Tomato","Vegetable", LocalDate.of(2024,03,10));
            plant1.setGarden(garden1);
            plantService.addPlant(plant1);

            Plant plant2 = new Plant("Carrot","Vegetable", LocalDate.of(2024,02,20));
            plant2.setGarden(garden1);
            plantService.addPlant(plant2);

            Plant plant3 = new Plant("Basil","Herb", LocalDate.of(2024,04,05));
            plant3.setGarden(garden2);
            plantService.addPlant(plant3);

            System.out.println("display all gardens");
            gardenService.findAll().forEach(System.out::println);

            System.out.println("display all garden plants sorted by name");
            plantService.getAllPlants().forEach(System.out::println);

            System.out.println("display all garden plants sorted by date");
            plantService.getAllPlantsWithSortedByDate().forEach(System.out::println);

            System.out.println("add new plant");
            Plant newPlant = new Plant("Rosemary","Herb", LocalDate.of(2024,11,05));
            newPlant.setGarden(garden2);
            plantService.addPlant(newPlant);
            plantService.getAllPlants().forEach(System.out::println);

            System.out.println("update plant");
            Optional<Plant> plant10 = plantService.getPlantByName("Tomato");
            plant10.ifPresent(plant -> plant.setType("Fruit"));
            plantService.updatePlant(plant10.get());

            plantService.getAllPlants().forEach(System.out::println);

            System.out.println("delete plant");
            Optional<Plant> plant11= plantService.getPlantByName("Carrot");
            plantService.deletePlant(plant11.get().getId());
            plantService.getAllPlants().forEach(System.out::println);

            System.out.println("update garden");
            Optional<Garden> gardenToBeUpdate = gardenService.findByGardenName("Herb Garden");
            gardenToBeUpdate.ifPresent(garden -> garden.setName("Herb Garden Update"));
            gardenService.update(gardenToBeUpdate.get());

            gardenService.findAll().forEach(System.out::println);

            System.out.println("delete one garden");
            Optional<Garden> gardenToBeDelete = gardenService.findByGardenName("Herb Garden Update");

            gardenService.deleteGarden(gardenToBeDelete.get().getId());
            gardenService.findAll().forEach(System.out::println);

            System.out.println("remaining plants garden");
            plantService.getAllPlants().forEach(System.out::println);






        };
    }
}
