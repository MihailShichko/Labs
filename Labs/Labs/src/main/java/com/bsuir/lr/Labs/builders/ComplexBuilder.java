package com.bsuir.lr.Labs.builders;

import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ComplexBuilder implements IBuilder{
    public String calculateAlgebraicForm(double real, double img) throws InterruptedException {
        Thread.sleep(1500);
        if (real > 10 || img > 10) throw new IllegalArgumentException("arguments can not be over 10");

        if (real < -5 || img < -5) throw new IllegalArgumentException("arguments can not be less then -5");

        return String.format("z = %f + %fi", real, img);
    }

    public String calculateExponentialForm(double real, double img) throws InterruptedException {
        Thread.sleep(1500);
        double r = Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2));
        if(img == 0.0) throw new ArithmeticException("Division By Zero");
        double fi = Math.atan(real / img);
        return String.format("z =%f + e^(i*%f)", r, fi);
    }

}
