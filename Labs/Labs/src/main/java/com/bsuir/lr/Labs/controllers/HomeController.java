package com.bsuir.lr.Labs.controllers;

import com.bsuir.lr.Labs.models.ComplexNumber;
import com.bsuir.lr.Labs.models.ComplexRequest;
import com.bsuir.lr.Labs.services.RequestCountService;
import com.bsuir.lr.Labs.builders.ComplexBuilder;
import jakarta.validation.constraints.DecimalMin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//27
@RestController
@RequestMapping("/home")
@Validated
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private RequestCountService counter;
    @Autowired
    private ComplexBuilder builder;
    @GetMapping("/index")
    public ComplexNumber index(@RequestParam(name = "real", required = false, defaultValue = "0") @DecimalMin("-5") double real,
                               @RequestParam(name = "img", required = false, defaultValue = "0") @DecimalMin("-5") double img) throws InterruptedException {
        logger.info("/index, method Get Succeded");
        var request = new ComplexRequest(real, img);
        var complex = builder.buildComplexNumber(request);
        return complex;
    }
    @GetMapping("/count")
    public int getCount(){
        return counter.getCount();
    }


}