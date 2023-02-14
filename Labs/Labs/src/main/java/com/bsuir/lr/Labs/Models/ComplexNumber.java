package com.bsuir.lr.Labs.Models;

import java.lang.String;

public class ComplexNumber
{
    //region Properties
    private final double real;
    public double getReal() { return real; }
    private final double img;
    public double getImg() { return img; }
    private String algebraicForm;
    public String getAlgebraicForm() { return algebraicForm; }
    private String exponentialForm;
    public String getExponentialForm() { return exponentialForm; }
    //endregion

    public ComplexNumber(double real, double img)
    {
        this.real = real;
        this.img = img;
        calculateAlgebraicForm();
        calculateExponentialForm();
    }

    //region PrivateMethods
    private void calculateAlgebraicForm()
    {
       this.algebraicForm = String.format("z = %a + %ai", this.real, this.img);
    }

    private void calculateExponentialForm()
    {
        double r = Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.img, 2));
        double fi = Math.atan(this.real / this.img);
        this.exponentialForm = String.format("z =%a + e^(i%a)", r, fi);
    }
    //endregion

}
