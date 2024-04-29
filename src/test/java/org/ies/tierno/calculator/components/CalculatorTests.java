package org.ies.tierno.calculator.components;

import org.ies.tierno.calculator.exceptions.DivideByZeroException;
import org.ies.tierno.calculator.exceptions.EmptyListException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CalculatorTests {
    private final static double DELTA = 0.00000001;

    @Test
    public void divideTest() throws DivideByZeroException {
        Calculator calculator = new Calculator();

        double res = calculator.divide(6, 3);

        Assert.assertEquals(2.0, res, DELTA);
    }

    @Test
    public void averageTest() throws EmptyListException {
        Calculator calculator = new Calculator();

        List<Double> numbers = List.of(3.5, 2.5, 3.0);

        double res = calculator.average(numbers);

        Assert.assertEquals(3.0, res, DELTA);
    }
}
