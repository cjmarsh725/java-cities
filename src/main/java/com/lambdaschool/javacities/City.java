package com.lambdaschool.javacities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class City
{
    private @Id @GeneratedValue Long id;
    private String name;
    private int population;
    private int affordability;

    public City() { }

    public City(String name, int population, int affordability)
    {
        this.name = name;
        this.population = population;
        this.affordability = affordability;
    }
}