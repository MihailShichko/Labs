package com.bsuir.lr.Labs.models;

import com.bsuir.lr.Labs.controllers.HomeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.lang.String;
public class ComplexNumber
{
    //region Properties
    private int id;
    private double real;
    private double img;
    private String algebraicForm;
    private String exponentialForm;
    public int getId(){
        return id;
    }
    public void setId(int value){
        id = value;
    }
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

    public ComplexNumber(int id, double real, double img, String algebraicForm, String exponentialForm){
        this.id = id;
        this.real = real;
        this.img = img;
        this.exponentialForm = exponentialForm;
        this.algebraicForm = algebraicForm;
    }

    public static int compare(ComplexNumber first, ComplexNumber second)
    {
        if((first.getReal() + first.getImg()) > (second.getReal() + second.getImg())) return 1;
        if((first.getReal() + first.getImg()) == (second.getReal() + second.getImg())) return 0;
        return -1;
    }

    public static int compareById(ComplexNumber first, ComplexNumber second)
    {
        if(first.getId() > second.getId()) return 1;
        if((first.getId()) == second.getId()) return 0;
        return -1;
    }
    @Override
    public String toString()
    {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}