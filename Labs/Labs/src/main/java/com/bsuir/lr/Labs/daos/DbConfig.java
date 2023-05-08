package com.bsuir.lr.Labs.daos;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.io.InputStream;
import java.nio.file.Files;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public DataSource dataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("src/main/java/com/bsuir/lr/Labs/daos/DataBasePriorities"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        return dataSource;
    }
    @Bean
    public JdbcTemplate template(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
