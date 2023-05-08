package com.bsuir.lr.Labs.services;

import java.util.ArrayList;
import com.bsuir.lr.Labs.models.ComplexNumber;
import org.springframework.stereotype.Service;

@Service
public class ComplexAggregator {
    public double average(ArrayList<ComplexNumber> repository){
        return repository.stream()
                .mapToDouble(num -> num.getImg() + num.getReal())
                .average()
                .orElseGet(() -> 0.0);
    }

    public ComplexNumber min(ArrayList<ComplexNumber> repository){
        return repository.stream()
                .min(ComplexNumber::compare)
                .get();
    }

    public ComplexNumber max(ArrayList<ComplexNumber> repository){
        return repository.stream()
                .max(ComplexNumber::compare)
                .get();
    }
}
