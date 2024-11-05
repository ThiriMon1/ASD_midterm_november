package edu.miu.cse.garden.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Double size;
    @OneToMany(mappedBy = "garden")
    private List<Plant> plants;

    public Garden(String name, Double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "GardenRepository{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
