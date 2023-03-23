package com.bsuir.lr.Labs.Models;

import com.bsuir.lr.Labs.Caching.CachingHashMap;
import com.bsuir.lr.Labs.builders.ComplexBuilder;
import com.bsuir.lr.Labs.builders.IBuilder;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;

import java.lang.String;

public class ComplexNumber
{
    //region Properties
    private double real;
    private double img;
    private String algebraicForm;
    private String exponentialForm;

    private IBuilder builder = new ComplexBuilder();
    public double getReal() { return real; }
    public double getImg() { return img; }

    public String getAlgebraicForm() { return algebraicForm; }
    public void setAlgebraicForm(String value) { this.algebraicForm = value; }

    public String getExponentialForm() { return exponentialForm; }
    public void setExponentialForm(String value) { this.exponentialForm = value; }

    private CachingHashMap cach = new CachingHashMap();
    //endregion


    public ComplexNumber(double real, double img) throws InterruptedException {
        var temp = new ComplexRequest(real, img);
        if(cach.contains(temp)) {
            this.algebraicForm = cach.getValue(temp).getAlgebraicForm();
            this.exponentialForm = cach.getValue(temp).getExponentialForm();
        }
        else{
            this.real = real;
            this.img = img;
            this.algebraicForm = ((ComplexBuilder)builder).calculateAlgebraicForm(real, img);
            this.exponentialForm = ((ComplexBuilder)builder).calculateExponentialForm(real, img);
            cach.addValue(temp, this);
        }

    }

}