package com.bsuir.lr.Labs.Models;

import com.bsuir.lr.Labs.builders.ComplexBuilder;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;

import java.lang.String;

public class ComplexNumber
{
    //region Properties
    private final double real;
    private final double img;
    private String algebraicForm;
    private String exponentialForm;

    public double getReal() { return real; }
    public double getImg() { return img; }
    public String getAlgebraicForm() { return algebraicForm; }
    public void setAlgebraicForm(String value) { this.algebraicForm = value; }

    public String getExponentialForm() { return exponentialForm; }
    public void setExponentialForm(String value) { this.exponentialForm = value; }
    //endregion


    public ComplexNumber(double real, double img, ComplexBuilder builder) throws InterruptedException {
        this.real = real;
        this.img = img;
        this.algebraicForm = builder.calculateAlgebraicForm(real, img);
        this.exponentialForm = builder.calculateExponentialForm(real, img);
    }

}