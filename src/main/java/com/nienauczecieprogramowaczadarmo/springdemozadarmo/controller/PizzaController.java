package com.nienauczecieprogramowaczadarmo.springdemozadarmo.controller;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.pizza.Pizza;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view") //wszystkie requesty zaczynajace sie od view beda nam serwowaly widoku
public class PizzaController {


    private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

    // /view/pizzas?provider
    @GetMapping("/pizzas")
    public String getMenu(Model model,
                          @RequestParam(value = "provider", defaultValue = "Tutti Santi") String pizzaProvider){ //zwracamy nazwe html

        logger.info("received pizzaProvider: [{}]", pizzaProvider);


        model.addAttribute("nazwaLokalu", pizzaProvider);
        model.addAttribute("allPizzas", pizzaService.getAllPizzaInMenu());

        return "menu/my-menu"; // przenosi nas do naszego pliku html
    }


}
//zadania Controllera - przyjmuje parametry od uzytkownika i zwraca widok
// Controller siega do service...
// service do repository...
// repository bierze dane i je przekazuje. w repository sa metody potrzebne do brania danych z baz danych. czyli tylko rzeczy typu
// pobierz dane, zapisz dane i TYLE
//service obrabia dane czyli np rozne stremy robi w tymi danymi itp

//controller odpowiada na requesty uzytkownika
//warstwa modelu: service , reposytoria

//model MVC

// zwykly controller jest jedynie nazwa widoku ktory chcemy zwrocic
//natomiast rest controller moze zwrocic np liste