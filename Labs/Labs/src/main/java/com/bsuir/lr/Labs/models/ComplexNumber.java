package com.bsuir.lr.Labs.models;

import com.bsuir.lr.Labs.controllers.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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