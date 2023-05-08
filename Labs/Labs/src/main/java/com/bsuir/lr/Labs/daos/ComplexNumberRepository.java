package com.bsuir.lr.Labs.daos;

import com.bsuir.lr.Labs.models.ComplexNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class ComplexNumberRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexNumberRepository.class);
    private final JdbcTemplate template;
    public ComplexNumberRepository(JdbcTemplate template)
    {
        this.template = template;
    }

    public List<ComplexNumber> getAll() {
        return template.query("SELECT * FROM complexnumber", new ComplexMapper());
    }

    public ComplexNumber get(int id) {
        return template.query("SELECT * FROM complexnumber WHERE id=?", new Object[]{id}, new ComplexMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public void insert(ComplexNumber num) {
        template.update("INSERT INTO complexnumber (id, realval, imgval, exponentialform, algebraicform) VALUES(DEFAULT, ?, ?, ?, ?)",
                num.getReal(), num.getImg(), num.getExponentialForm(), num.getAlgebraicForm());
    }

    public void update(int id, ComplexNumber newVal){
        template.update("UPDATE complexnumber SET realval=?, imgval=?, exponentialform=?,algebraicform=? WHERE id=?",
                newVal.getReal(), newVal.getImg(), newVal.getExponentialForm(), newVal.getAlgebraicForm(), id);
    }

    public void delete(int id) {
        template.update("DELETE FROM complexnumber WHERE id=?", id);
    }

}
