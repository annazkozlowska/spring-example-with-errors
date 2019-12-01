package com.nienauczecieprogramowaczadarmo.springdemozadarmo.controller;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.pizza.Pizza;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaRestController {

    @GetMapping("/menu")
    List<Pizza> getMenu(){
        return Pizza.getPizzas();
    }


}

//2 controllery, 1 webowy, 1 restowy
// na webowym wyswietlamu swoj adres
// na restowym tez

