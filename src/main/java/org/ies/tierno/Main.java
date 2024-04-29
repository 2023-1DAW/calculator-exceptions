package org.ies.tierno;

import org.ies.tierno.calculator.components.Calculator;
import org.ies.tierno.calculator.components.CalculatorApp;
import org.ies.tierno.calculator.exceptions.DivideByZeroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        CalculatorApp calculatorApp = new CalculatorApp(scanner, calculator);
        calculatorApp.run();

    }
}