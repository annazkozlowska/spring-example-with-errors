package com.nienauczecieprogramowaczadarmo.springdemozadarmo.controller;


import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view/ad")
public class AddressController {

    @GetMapping("/new-way")
    public ModelAndView getMyAddresss(ModelAndView modelAndView) {
        modelAndView.addObject("myAddress", new Address("Wwa", "xxx", "11-111"));
        modelAndView.setViewName("menu/address");
        return modelAndView;
    }

    @GetMapping("/old-way")
    public String getAddress(Model model) {

        model.addAttribute("myAddress", new Address("Wwa", "xxx", "11-111"));
        return "menu/address";
    }
}
