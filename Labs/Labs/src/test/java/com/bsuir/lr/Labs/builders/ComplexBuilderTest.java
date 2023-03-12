package com.bsuir.lr.Labs.builders;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
    void AlgebraicFormValidTest() {
        for(var testCase : ValidCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            algebraicForm = (String)testCase[2];
            Assert.assertEquals(algebraicForm, builder.calculateAlgebraicForm(real,img));
        }
    }
    @Test
    void ArithmeticExceptionTests() {
        for (var testCase: ArithmeticInvalidTestCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            Assert.assertThrows(ArithmeticException.class, ()->
            {
                builder.calculateExponentialForm(real, img);
            });
        }
    }
    @Test
    void IllegalArgumentExceptionTests() {
        for (var testCase: IllegalArgInvalidTestCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            Assert.assertThrows(IllegalArgumentException.class, ()->
            {
                builder.calculateAlgebraicForm(real, img);
                builder.calculateExponentialForm(real, img);
            });
        }
    }
    @Test
    void ExponentialFormValidTest() {
        for(var testCase : ValidCases) {
            real = (double)testCase[0];
            img = (double)testCase[1];
            exponencialForm = (String)testCase[3];
            Assert.assertEquals(exponencialForm, builder.calculateExponentialForm(real,img));
        }
    }




}