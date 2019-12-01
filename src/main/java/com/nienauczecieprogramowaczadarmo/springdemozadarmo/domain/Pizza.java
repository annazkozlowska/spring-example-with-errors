package com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private int size;
    private String name;
    @ElementCollection
    private List<String> ingredients;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Pizza() {
    }
    public Pizza(double price, int size, String name, List<String> ingredients) {
        this.price = price;
        this.size = size;
        this.name = name;
        this.ingredients = ingredients;
    }
    @JsonIgnore
    public double getPrice() {
        return price;
    }
    @JsonIgnore
    public int getSize() {
        return size;
    }
    public String getName() {
        return name;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(price, size, name, ingredients);
//    }
}