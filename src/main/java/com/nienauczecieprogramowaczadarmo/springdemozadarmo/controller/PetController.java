package com.nienauczecieprogramowaczadarmo.springdemozadarmo.controller;


import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Pet;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pets")
public class PetController {

    private static final Logger logger = LoggerFactory.getLogger(PizzaController.class);

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // /pets/pet/4
    @GetMapping("/pet/{id}")
    public ModelAndView displayPetById(ModelAndView modelAndView, @PathVariable("id") Long id){
        modelAndView.addObject("zwierzak", petService.findById(id).orElse(new Pet()));
        modelAndView.setViewName("pet/favurite-pet");

        return modelAndView;
    }


}
