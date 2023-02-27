package com.bsuir.lr.Labs.builders;

public class ComplexBuilder {
    public String calculateAlgebraicForm(double real, double img) {
        if (real > 10 || img > 10) throw new IllegalArgumentException("arguments can not be over 10");

        if (real < -5 || img < -5) throw new IllegalArgumentException("arguments can not be less then 10");

        return String.format("z = %f + %fi", real, img);
    }

    public String calculateExponentialForm(double real, double img) {
        double r = Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2));
        double fi = Math.atan(real / img);
        return String.format("z =%f + e^(i*%f)", r, fi);
    }

}
