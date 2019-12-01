package com.nienauczecieprogramowaczadarmo.springdemozadarmo.service;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.pizza.Pizza;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository.PizzaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PizzaService {

    private static final Logger logger = LoggerFactory.getLogger(PizzaService.class);

    private PizzaRepo pizzaRepo;

    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public List<Pizza> getAllPizzaInMenu(){

        logger.info("getAllPizzaInMenu");
        return pizzaRepo.getAllPizzas();
    }

    List<Pizza> getPizzasWithIngredient(List<String> ingredients){

        logger.info("getPizzasWithIngredient");
        return Collections.emptyList();
    }
}
// service w najprostrzej postaci