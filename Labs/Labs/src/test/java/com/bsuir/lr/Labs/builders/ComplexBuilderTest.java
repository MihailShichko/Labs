package com.bsuir.lr.Labs.builders;

import com.bsuir.lr.Labs.Models.ComplexRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class ComplexBuilderTests {


    ComplexBuilder builder = new ComplexBuilder();
    private List<Object[]> ArithmeticInvalidTestCases = new ArrayList<Object[]>(
            Arrays.asList(
                    new Object[]{-1.0, 0.0},
                    new Object[]{1.0, 0.0}));
    private List<Object[]> IllegalArgInvalidTestCases = new ArrayList<Object[]>(
            Arrays.asList(
                    new Object[] {100.0, 3.0},
                    new Object[] {100.0, 0.0}));
    private List<Object[]> ValidCases = new ArrayList<Object[]>(
            Arrays.asList(
                    new Object[] {4.0, 3.0, "z = 4,000000 + 3,000000i", "z =5,000000 + e^(i*0,927295)"},
                    new Object[] {4.0, 8.0, "z = 4,000000 + 8,000000i", "z =8,944272 + e^(i*0,463648)"}
            ));
    
    private double img;
    private double real;
    private String algebraicForm;
    private String exponencialForm;
    @Test
    void algebraicFormValidTest() throws InterruptedException {
        for(var testCase : ValidCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            algebraicForm = (String)testCase[2];
            var actual = builder.buildComplexNumber(new ComplexRequest(real, img));
            Assert.assertEquals(algebraicForm, actual.getAlgebraicForm());
        }
    }
    @Test
    void arithmeticExceptionTests() {
        for (var testCase: ArithmeticInvalidTestCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            Assert.assertThrows(ArithmeticException.class, ()->
            {
                builder.buildComplexNumber(new ComplexRequest(real, img));
            });
        }
    }
    @Test
    void illegalArgumentExceptionTests() {
        for (var testCase: IllegalArgInvalidTestCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            Assert.assertThrows(IllegalArgumentException.class, ()->
            {
                builder.buildComplexNumber(new ComplexRequest(real, img));
            });
        }
    }
    @Test
    void exponentialFormValidTest() throws InterruptedException {
        for(var testCase : ValidCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            exponencialForm = (String)testCase[3];
            var actual = builder.buildComplexNumber(new ComplexRequest(real, img));
            Assert.assertEquals(exponencialForm, actual.getExponentialForm());
        }
    }




}