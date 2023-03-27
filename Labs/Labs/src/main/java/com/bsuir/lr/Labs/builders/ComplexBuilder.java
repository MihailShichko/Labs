package com.bsuir.lr.Labs.builders;

import com.bsuir.lr.Labs.caching.CachingHashMap;
import com.bsuir.lr.Labs.models.ComplexNumber;
import com.bsuir.lr.Labs.models.ComplexRequest;
import com.bsuir.lr.Labs.services.RequestCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplexBuilder{
//переделать чтобы все тут было
    @Autowired
    private CachingHashMap cach;
    @Autowired
    private RequestCountService counter;

    public ComplexNumber buildComplexNumber(ComplexRequest request) throws InterruptedException {
        counter.incrementCount();
        var result = new ComplexNumber(request.getReal(), request.getImg());
        if(cach.contains(request)) {
            result = cach.getValue(request);
        }
        else{
            result.setAlgebraicForm(calculateAlgebraicForm(request.getReal(), request.getImg()));
            result.setExponentialForm(calculateExponentialForm(request.getReal(), request.getImg()));
            cach.addValue(request, result);
        }

        return result;
    }

    private String calculateAlgebraicForm(double real, double img) throws InterruptedException {
        Thread.sleep(1500);
        if (real > 10 || img > 10) throw new IllegalArgumentException("arguments can not be over 10");

        if (real < -5 || img < -5) throw new IllegalArgumentException("arguments can not be less then -5");

        return String.format("z = %f + %fi", real, img);
    }

    private String calculateExponentialForm(double real, double img) throws InterruptedException {
        Thread.sleep(1500);
        double r = Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2));
        if(img == 0.0) throw new ArithmeticException("Division By Zero");
        double fi = Math.atan(real / img);
        return String.format("z =%f + e^(i*%f)", r, fi);
    }

}
