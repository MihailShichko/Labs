package com.bsuir.lr.Labs.daos;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

import com.bsuir.lr.Labs.controllers.HomeController;
import com.bsuir.lr.Labs.models.ComplexNumber;
import jdk.dynalink.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplexNumberRepository {
    private List<ComplexNumber> repository = new ArrayList<ComplexNumber>();
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexNumberRepository.class);
    private Connection db;

    public void add(ComplexNumber num) {
        repository.add(num);
    }

    public ComplexNumberRepository()
    {
        try{
            this.db = getConnection();
        }
        catch (Exception ex)
        {
            LOGGER.info("Connection to database failed");
            LOGGER.info(ex.getMessage());
        }
    }

    public void Insert(ComplexNumber num) {
        try {
            PreparedStatement statement = db.prepareStatement("INSERT complexnum VALUES (1, ?, ?, ?)");
            statement.setDouble(1, num.getReal());
            statement.setDouble(2, num.getImg());
            statement.setString(3, num.getExponentialForm());
            statement.setString(4, num.getAlgebraicForm());
            int rows = statement.executeUpdate();

            LOGGER.info(String.format("%d strings are written into db"), rows);
        }
        catch (SQLException ex){
            LOGGER.info(ex.getMessage());
        }
    }
    public List<ComplexNumber> getAll() {
        return repository;
    }

    private Connection getConnection() throws SQLException, IOException
    {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("src/main/java/com/bsuir/lr/Labs/daos/DataBasePriorities"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
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

