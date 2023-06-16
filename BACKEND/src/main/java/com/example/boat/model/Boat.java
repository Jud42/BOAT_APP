package com.example.boat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Description;

    //constructor
    public Boat() {
        Name = null;
        Description = null;
    }
    public Boat(String name, String description) {
        Name = name;
        Description = description;
    }

    //getters
    public String getDescription() {
        return Description;
    }
    public String getName() {
        return Name;
    }
}