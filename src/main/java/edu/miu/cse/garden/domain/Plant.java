package edu.miu.cse.garden.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String type;
    private LocalDate plantDate;
    @ManyToOne
    @JoinColumn(name="garden_id")
    private Garden garden;

    public Plant(String name, String type, LocalDate plantDate) {
        this.name = name;
        this.type = type;
        this.plantDate = plantDate;
    }

    @Override
    public String toString() {
        return "PlantRepository{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", plantDate=" + plantDate +
                ", garden=" + garden.getName() +
                '}';
    }
}
