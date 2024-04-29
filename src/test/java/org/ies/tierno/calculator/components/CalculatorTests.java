package org.ies.tierno.calculator.components;

import org.ies.tierno.calculator.exceptions.DivideByZeroException;
import org.ies.tierno.calculator.exceptions.EmptyListException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTests {
    private final static double DELTA = 0.00000001;

    @Test
    public void divide6By3Test() throws DivideByZeroException {
        // Preparación del test
        Calculator calculator = new Calculator();
        double numerator = 6;
        double denominator = 3;

        // Ejecución del test
        double res = calculator.divide(numerator, denominator);

        // Comprobaciones (Asserts)
        Assert.assertEquals(2.0, res, DELTA);
    }

    @Test
    public void divide2By3Test() throws DivideByZeroException {
        // Preparación del test
        Calculator calculator = new Calculator();
        double numerator = 2;
        double denominator = 3;

        // Ejecución del test
        double res = calculator.divide(numerator, denominator);

        // Comprobaciones (Asserts)
        Assert.assertEquals(0.66666666666, res, DELTA);
    }

    @Test(expected = DivideByZeroException.class)
    public void divide2By0Test() throws DivideByZeroException {
        // Preparación del test
        Calculator calculator = new Calculator();
        double numerator = 2;
        double denominator = 0;

        // Ejecución del test
        calculator.divide(numerator, denominator);
    }

    @Test
    public void averageTest() throws EmptyListException {
        Calculator calculator = new Calculator();

        List<Double> numbers = List.of(3.5, 2.5, 3.0);

        double res = calculator.average(numbers);

        Assert.assertEquals(3.0, res, DELTA);
    }

    @Test(expected = EmptyListException.class)
    public void averageEmptyListTest() throws EmptyListException {
        Calculator calculator = new Calculator();

        List<Double> numbers = new ArrayList<>();

        calculator.average(numbers);
    }
}
