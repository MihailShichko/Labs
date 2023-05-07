package com.bsuir.lr.Labs.daos;

import com.bsuir.lr.Labs.models.ComplexNumber;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplexMapper implements RowMapper<ComplexNumber> {

    @Override
    public ComplexNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ComplexNumber(rs.getInt("id") ,rs.getDouble("realval"), rs.getDouble("imgval"),
                rs.getString("algebraicform"), rs.getString("exponentialform"));
    }
}
