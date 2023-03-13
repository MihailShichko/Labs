package com.bsuir.lr.Labs.Controllers;

import com.bsuir.lr.Labs.Models.ComplexNumber;
import com.bsuir.lr.Labs.builders.ComplexBuilder;
import jakarta.validation.constraints.DecimalMin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



import java.io.IOException;

//27
@RestController
@RequestMapping("/home")
@Validated
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private ComplexBuilder builder;

    public HomeController(ComplexBuilder builder)
    {
        this.builder = builder;
    }

    @GetMapping("/index")
    public ComplexNumber index(@RequestParam(name = "real", required = false, defaultValue = "0") @DecimalMin("-5") double real,
                               @RequestParam(name = "img", required = false, defaultValue = "0") @DecimalMin("-5") double img) throws InterruptedException {
        var complex = new ComplexNumber(real, img, builder);
        logger.info("/index, method Get Succeded");
        return complex;
    }



}