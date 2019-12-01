package com.nienauczecieprogramowaczadarmo.springdemozadarmo.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    ///calculate-sum/5/10
    @GetMapping("/calculate-sum/{sklad_1}/{sklad_2}") // zadaniem tego jest zawołanie tej metody
    public int sum(@PathVariable("sklad_2") Integer a,
                   @PathVariable("sklad_1") Integer b){
        return a + b;
    }

    ///calculate-sub/5/10
    @GetMapping("/calculate-sub/{sklad_1}/{sklad_2}")
    public int sub(@PathVariable("sklad_1") Integer a,
                   @PathVariable("sklad_2") Integer b){
        return a - b;
    }
    @GetMapping("/calculate-mult/{sklad_1}/{sklad_2}")
    public Long mult(@PathVariable("sklad_1") Long a,
                     @PathVariable("sklad_2") Long b){
        return a * b;
    }

    // /mult2?first=5&second=8
    @GetMapping("/mult2")
    public Long mult1(@RequestParam(value ="first", defaultValue = "0") Long param1,
                      @RequestParam(value = "second", defaultValue = "0") Long param2){

        logger.debug("debug message");
        logger.info("tutaj");
        logger.warn("warn");
        logger.error("error");
        return param1 * param2;
    }


    @GetMapping("/calculate-div/{sklad_1}/{sklad_2}")
    public Double div(@PathVariable("sklad_1") Double a,
                      @PathVariable("sklad_2") Double b){
        return a / b;
    }

    // /div2?first=100&second=10
    public Double div2(@RequestParam(value ="first", defaultValue = "0") Double param1,
                      @RequestParam(value = "second", defaultValue = "0") Double param2){
        return param1 / param2;
    }


}
