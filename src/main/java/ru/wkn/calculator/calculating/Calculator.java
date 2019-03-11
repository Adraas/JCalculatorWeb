package ru.wkn.calculator.calculating;

/**
 * The class of a basic arithmetic operations.
 * @author Pikalov Artem.
 */

public class Calculator {

    /**
     * The field containing rounding accuracy for floating point operations.
     */
    private int roundingAccuracy;

    /**
     * Constructs an {@code Calculator} with the rounding accuracy value.
     * @param roundingAccuracy - value of the rounding accuracy.
     */
    public Calculator(int roundingAccuracy) {
        setRoundingAccuracy(roundingAccuracy);
    }

    public int getRoundingAccuracy() {
        return roundingAccuracy;
    }

    public void setRoundingAccuracy(int roundingAccuracy) {
        if (roundingAccuracy <= 0) {
            throw new NumberFormatException("Value of the rounding accuracy is incorrect: "
                    .concat(String.valueOf(roundingAccuracy).concat(";\n"))
                    .concat("Expected value > 0."));
        }
        this.roundingAccuracy = roundingAccuracy;
    }

    public double sum(double firstAddend, double secondAddend) {
        return round(firstAddend + secondAddend);
    }

    public double subtract(double minuend, double subtrahend) {
        return round(minuend - subtrahend);
    }

    public double multiply(double firstMultiplier, double secondMultiplier) {
        return round(firstMultiplier * secondMultiplier);
    }

    public double division(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return round(dividend / divisor);
    }

    public double root(double value, double power) throws ArithmeticException {
        if (value < 0 && power % 2 == 0) {
            throw new ArithmeticException("Even root of negative number!");
        }
        int signum = (int) Math.signum(value);
        return round(Math.pow(Math.abs(value), (double) 1 / power)) * signum;
    }

    public double power(double value, double degree) throws ArithmeticException {
        return round(Math.pow(value, degree));
    }

    public double round(double value) {
        int accuracyCoefficient = (int) Math.pow(10, roundingAccuracy);
        return (double) Math.round(value * accuracyCoefficient) / accuracyCoefficient;
    }
}
