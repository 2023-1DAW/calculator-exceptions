package org.ies.tierno.calculator.components;

import org.ies.tierno.calculator.exceptions.DivideByZeroException;
import org.ies.tierno.calculator.exceptions.EmptyListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    private static final Logger log = LoggerFactory.getLogger(CalculatorApp.class);
    private final Scanner scanner;
    private final Calculator calculator;

    public CalculatorApp(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    public void run() {
        Integer opt = null;
        do {
            opt = chooseOption();
            if (opt == 1) {
                runDivideOption();
            } else if (opt == 2) {
                runAverageOption();
            }
        } while (opt != 3);
    }

    private void runAverageOption() {
        try {
            List<Double> numbers = askNumbers();
            double res = calculator.average(numbers);
            log.info("La media es " + res);
        } catch (EmptyListException e) {
            log.error("No se puede calcular la media de una lista vacía");
        }
    }

    private void runDivideOption() {
        try {
            double numerator = askDouble("Introduce el numerador");
            double denominator = askDouble("Introduce el denominador (distinto de cero)");

            double res = calculator.divide(numerator, denominator);
            log.info("La división es " + res);
        } catch (DivideByZeroException e) {
            log.error("No se puede dividir por cero");
        }
    }

    public List<Double> askNumbers() {
        List<Double> numbers = new ArrayList<>();
        boolean moreNumbers = true;
        log.info("Introduce los números");
        do {
            numbers.add(askDouble("Introduce número"));
            log.info("¿Desea meter más números? (Y/n)");
            String response = scanner.nextLine();
            moreNumbers = !response.equalsIgnoreCase("n");

        } while (moreNumbers);
        return numbers;
    }

    private double askDouble(String message) {
        Double number = null;
        do {
            log.info(message);
            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un double");
            } finally {
                scanner.nextLine();
            }
        } while (number == null);
        return number;
    }

    private Integer chooseOption() {
        log.info("Elige una opción:");
        log.info("1. Sumar");
        log.info("2. Media");
        log.info("3. Salir");
        Integer option = null;
        do {
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un entero");
            } finally {
                scanner.nextLine();
            }
        } while (option == null);
        return option;
    }
}
