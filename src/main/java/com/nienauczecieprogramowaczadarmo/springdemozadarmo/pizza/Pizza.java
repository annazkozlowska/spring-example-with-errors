package com.nienauczecieprogramowaczadarmo.springdemozadarmo.pizza;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pizza {


    private double price;
    private int size;
    private String name;
    private List<String> ingredients;


    public Pizza() {
    }
    public Pizza(double price, int size, String name, List<String> ingredients) {
        this.price = price;
        this.size = size;
        this.name = name;
        this.ingredients = ingredients;
    }

    @JsonIgnore // służy do ukrycia danej wartości przed Jsonem
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Pizza{" +
                "price=" + price +
                ", size=" + size +
                ", ingredients=" + ingredients +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Double.compare(pizza.price, price) == 0 &&
                size == pizza.size &&
                Objects.equals(ingredients, pizza.ingredients) &&
                Objects.equals(name, pizza.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(price, size, name, ingredients);
    }

    public static void main(String[] args) {

        // 3 x nowe pizze
        // z listy nazwe pizze
        // wybierz liste unikanych skladnikow

        List<Pizza> pizzas = getPizzas();

        pizzas.stream()
                .map(pizza -> pizza.getName())
                .collect(Collectors.toList())
                .forEach(pizzaName -> System.out.println("pizza name: " + pizzaName));


        List<String> unikalneSkladniki = pizzas.stream()
                .map(pizza -> pizza.getIngredients())
                .flatMap(ingredientsList -> ingredientsList.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unikalne Składniki :" + unikalneSkladniki);


        System.out.println(".....");
        pizzas.stream()
                .filter(pizza -> !pizza.getIngredients().contains("mozzarella") && !pizza.getIngredients().contains("pomidory"))
                .map(pizza -> pizza.getName())
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e));


    }

    public static List<Pizza> getPizzas() {
        return Arrays.asList(
                    new Pizza(30, 50, "hawajska", Arrays.asList("pomidory", "ananasy", "papryka")),
                    new Pizza(45, 50, "capriciosa", Arrays.asList("mozzarella", "pomidory", "salami")),
                    new Pizza(45, 40, "bianca", Arrays.asList("mozzarella", "szparagi", "sos smietanowy")),
                    new Pizza(50, 50, "wiejska", Arrays.asList("salami", "szynka", "papryka")),
                    new Pizza(40, 50, "meksykańska", Arrays.asList("salami", "kukurydza", "papryka")),
                    new Pizza(50, 50, "marinara", Arrays.asList("pomidory", "mozzarella", "czosnek"))
            );
    }
}
