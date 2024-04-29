package org.ies.tierno.calculator.components;

import org.ies.tierno.calculator.exceptions.DivideByZeroException;
import org.ies.tierno.calculator.exceptions.EmptyListException;

import java.util.List;

public class Calculator {

    public double divide(double numerator, double denominator) throws DivideByZeroException {
        if (denominator == 0) {
            throw new DivideByZeroException();
        } else {
            return numerator / denominator;
        }
    }

    public double average(List<Double> numbers) throws EmptyListException {
        if (numbers.isEmpty()) {
            throw new EmptyListException();
        } else {
            double sum = 0;
            for (double number : numbers) {
                sum += number;
            }
            return sum / numbers.size();

        }

//        return numbers
//                // Convertimos a Stream
//                .stream()
//                // Devuelve Optional<Double>, si no había ningún elemento Option.empty
//                .reduce((a, b) -> a + b)
//                // Si el Optional<Double> no está vacío, calculo la media
//                .map(sum -> sum / numbers.size())
//                // Se el Optional<Double> no está vacío, lo devuelve. Si está vacío
//                // lanza la excepción EmptyListException
//                .orElseThrow(() -> new EmptyListException());
    }
}
