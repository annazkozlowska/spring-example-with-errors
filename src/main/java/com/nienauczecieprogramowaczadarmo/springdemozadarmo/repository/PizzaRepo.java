package com.nienauczecieprogramowaczadarmo.springdemozadarmo.repository;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.pizza.Pizza;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class PizzaRepo {

    private static final Logger logger = LoggerFactory.getLogger(PizzaRepo.class);

    public static final List<Pizza> pizzas = Arrays.asList(
                new Pizza(30, 50, "hawajska", Arrays.asList("pomidory", "ananasy", "papryka")),
                new Pizza(45, 50, "capriciosa", Arrays.asList("mozzarella", "pomidory", "salami")),
                new Pizza(45, 40, "bianca", Arrays.asList("mozzarella", "szparagi", "sos smietanowy")),
                new Pizza(50, 50, "wiejska", Arrays.asList("salami", "szynka", "papryka")),
                new Pizza(40, 50, "meksykańska", Arrays.asList("salami", "kukurydza", "papryka")),
                new Pizza(50, 50, "marinara", Arrays.asList("pomidory", "mozzarella", "czosnek"))
        );

    public List<Pizza> getAllPizzas(){
        logger.info("getAllPizzas(), returned {} pizzas", pizzas.size());
        return pizzas;
    }
}
