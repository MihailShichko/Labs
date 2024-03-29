package com.bsuir.lr.Labs.controllers;

import com.bsuir.lr.Labs.daos.ComplexNumberRepository;
import com.bsuir.lr.Labs.models.ComplexNumber;
import com.bsuir.lr.Labs.models.ComplexRequest;
import com.bsuir.lr.Labs.services.RequestCountService;
import com.bsuir.lr.Labs.builders.ComplexBuilder;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;

//27
@RestController
@RequestMapping("/home")
@Validated
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private RequestCountService counter;
    private ComplexNumberRepository repository;
    @Autowired
    private ComplexBuilder builder;
    public HomeController(ComplexNumberRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/index")
    public ComplexNumber index(@RequestParam(name = "real", required = false, defaultValue = "0") @DecimalMin("-5") double real,
                               @RequestParam(name = "img", required = false, defaultValue = "0") @DecimalMin("-5") double img) throws InterruptedException {
        var request = new ComplexRequest(real, img);
        logger.info("started async call");
        CompletableFuture.supplyAsync(() -> {
                    try {
                        return builder.buildComplexNumber(request);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenAccept(complex -> repository.insert(complex));

        logger.info("ready to send responce");
        return repository.getAll().stream()
                .max(ComplexNumber::compareById)
                .get();
    }
    @GetMapping("/count")
    public int getCount()
    {
        return counter.getCount();
    }

    @PostMapping("/addRange")
    public ResponseEntity<?> addRange(@RequestBody List<ComplexRequest> request)
    {
            builder.buildComplexNumList(request)
                    .stream()
                    .forEach(num -> repository.insert(num));


            return new ResponseEntity<>(repository.getAll(), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ComplexNumber getComplex(@RequestParam(name = "id", required = true, defaultValue = "0") @Min(0) int id)
    {
        return repository.get(id);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteComplex(@RequestParam(name = "id", required = true, defaultValue = "0") @Min(0) int id)
    {
        repository.delete(id);
        return new ResponseEntity<>("Numbers left:\n" + repository.getAll(), HttpStatus.OK);
    }
}