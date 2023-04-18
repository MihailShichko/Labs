package com.bsuir.lr.Labs.daos;

import com.bsuir.lr.Labs.models.ComplexNumber;
import jdk.dynalink.Operation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplexNumberRepository {
    private List<ComplexNumber> repository = new ArrayList<ComplexNumber>();
    public void add(ComplexNumber num) {
        repository.add(num);
    }

    public List<ComplexNumber> getAll() {
        return repository;
    }

    public double average(){
        return repository.stream()
                .mapToDouble(num -> num.getImg() + num.getReal())
                .average()
                .getAsDouble();
    }

    public ComplexNumber min(){
        return repository.stream()
                .min(ComplexNumber::compare)
                .get();
    }

    public ComplexNumber max(){
        return repository.stream()
                .max(ComplexNumber::compare)
                .get();
    }

}

