package com.bsuir.lr.Labs.Models;

import com.bsuir.lr.Labs.Caching.CachingHashMap;
import com.bsuir.lr.Labs.Controllers.HomeController;
import com.bsuir.lr.Labs.builders.ComplexBuilder;
import com.bsuir.lr.Labs.builders.IBuilder;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.String;
public class ComplexNumber
{
    //region Properties
    private double real;
    private double img;
    private String algebraicForm;
    private String exponentialForm;
    public double getReal() { return real; }
    public double getImg() { return img; }

    public String getAlgebraicForm() { return algebraicForm; }
    public void setAlgebraicForm(String value) { this.algebraicForm = value; }

    public String getExponentialForm() { return exponentialForm; }
    public void setExponentialForm(String value) { this.exponentialForm = value; }
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //endregion

    public ComplexNumber(double real, double img){
        this.real = real;
        this.img = img;
    }

}