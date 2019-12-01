package com.nienauczecieprogramowaczadarmo.springdemozadarmo.controller;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Owner;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    public static final Logger logger = LoggerFactory.getLogger(OwnerController.class);
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    // /owner/all-owners
    @GetMapping("/all-owners")
    public ModelAndView allOwners(ModelAndView modelAndView) {

        modelAndView.addObject("posiadacze",ownerService.allOwners());
        modelAndView.setViewName("owner/owners");

        return modelAndView;
    }

    // /owner/new-owner-form
    @GetMapping("/new-owner-form")
    public ModelAndView newOwner(ModelAndView modelAndView){
        logger.info("displaying new owner form");
        modelAndView.setViewName("owner/new-owner");
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveOwner(Owner owner){
        logger.info("maybe save");
        logger.info("nick: [{}]", owner);

        ownerService.saveOwner(owner);

        return "redirect:/owner/all-owners";

    }
}



//model and view okresla
