package com.bsuir.lr.Labs.daos;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

import com.bsuir.lr.Labs.models.ComplexNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Repository
public class ComplexNumberRepository {
    private List<ComplexNumber> repository = new ArrayList<ComplexNumber>();//https://www.youtube.com/watch?v=cwmGcX5jVwE
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexNumberRepository.class);

    private final JdbcTemplate template;
    public void add(ComplexNumber num) {
        repository.add(num);
    }

    public ComplexNumberRepository(JdbcTemplate template)
    {
        this.template = template;
    }

    public List<ComplexNumber> getAll() {
       return template.query("SELECT * FROM numbers", new ComplexMapper());
    }

    public ComplexNumber get(int id) {
         return template.query("SELECT * FROM numbers WHERE id=?", new Object[]{id}, new ComplexMapper())
                 .stream()
                 .findAny()
                 .orElse(null);
    }

    public void insert(ComplexNumber num) {
        template.update("INSERT INTO numbers VALUES(1, ?, ?, ?, ?)",
                num.getReal(), num.getImg(), num.getExponentialForm(), num.getAlgebraicForm());
    }

    public void update(int id, ComplexNumber newVal){
        template.update("UPDATE numbers SET realval=?, imgval=?, exponentialform=?,algebraicform=? WHERE id=?",
                newVal.getReal(), newVal.getImg(), newVal.getExponentialForm(), newVal.getAlgebraicForm(), id);
    }

    public void delete(int id) {
        template.update("DELETE FROM numbers WHERE id=?", id);
    }
    public double average(){
        return repository.stream()
                .mapToDouble(num -> num.getImg() + num.getReal())
                .average()
                .orElseGet(() -> 0.0);
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