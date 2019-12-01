package com.nienauczecieprogramowaczadarmo.springdemozadarmo.controller;

import com.nienauczecieprogramowaczadarmo.springdemozadarmo.domain.Address;
import com.nienauczecieprogramowaczadarmo.springdemozadarmo.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressRestController {

    private AddressService addressService;

    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    // menu/address/my-addresss
    @GetMapping("/my-address")
    public Address getMyAddress(){
     return new Address("Warszawa", "Kinowa", "01-000");
    }

    // menu/address/save?city=Ciechocinek&street=Wakacyjna&postalCode=500
    @GetMapping("/save")
    public Address saveNewAddress(@RequestParam("city") String city,
                                  @RequestParam("street") String street,
                                  @RequestParam("postalCode") String postalCode){
        Address toSave = new Address(city, street, postalCode);
        return addressService.saveNewAddress(toSave);
    }

}


