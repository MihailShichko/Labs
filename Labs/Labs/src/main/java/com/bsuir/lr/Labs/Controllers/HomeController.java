package com.bsuir.lr.Labs.Controllers;

import com.bsuir.lr.Labs.Models.ComplexNumber;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

//27
@RestController
public class HomeController {
    @GetMapping("/Home/Index")
    public String Index(@RequestParam double real, @RequestParam double img) throws JsonProcessingException {
        var complex = new ComplexNumber(real, img);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(complex);
    }

}
