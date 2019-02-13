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
    private int homePrice;
    private int affordability;

    public City() { }

    public City(String name, int homePrice, int affordability)
    {
        this.name = name;
        this.homePrice = homePrice;
        this.affordability = affordability;
    }
}