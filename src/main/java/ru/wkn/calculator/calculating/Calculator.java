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
     *
     * @param roundingAccuracy - value of the rounding accuracy
     */
    public Calculator(int roundingAccuracy) {
        setRoundingAccuracy(roundingAccuracy);
    }

    /**
     * The method to get the field {@link Calculator#roundingAccuracy} value.
     *
     * @return the rounding accuracy value
     */
    public int getRoundingAccuracy() {
        return roundingAccuracy;
    }

    /**
     * The method of {@link Calculator#roundingAccuracy} identification.
     *
     * @param roundingAccuracy - value of the rounding accuracy
     */
    public void setRoundingAccuracy(int roundingAccuracy) {
        if (roundingAccuracy <= 0) {
            throw new NumberFormatException("Value of the rounding accuracy is incorrect: "
                    .concat(String.valueOf(roundingAccuracy).concat(";\n"))
                    .concat("Expected value > 0."));
        }
        this.roundingAccuracy = roundingAccuracy;
    }

    /**
     * The method of finding the sum.
     *
     * @param firstAddend - first addend for sum operation
     * @param secondAddend - second addend for sum operation
     * @return {@link Calculator#round(double)} - rounded value of sum operation
     */
    public double sum(double firstAddend, double secondAddend) {
        return round(firstAddend + secondAddend);
    }

    /**
     * The method of finding the subtract.
     *
     * @param minuend - minuend for subtract operation
     * @param subtrahend - subtrahend for subtract operation
     * @return {@link Calculator#round(double)} - rounded value of subtract operation
     */
    public double subtract(double minuend, double subtrahend) {
        return round(minuend - subtrahend);
    }

    /**
     * The method of finding the multiply.
     *
     * @param firstMultiplier - first multiplier for multiply
     * @param secondMultiplier - second multiplier for multiply
     * @return {@link Calculator#round(double)} - rounded value of multiply operation
     */
    public double multiply(double firstMultiplier, double secondMultiplier) {
        return round(firstMultiplier * secondMultiplier);
    }

    /**
     * The method of finding the division.
     *
     * @param dividend - dividend for division operation
     * @param divisor - divisor for division operation
     * @return {@link Calculator#round(double)} - rounded value of division operation
     * @throws ArithmeticException if there is an attempt to divide by zero
     */
    public double division(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return round(dividend / divisor);
    }

    /**
     * The method of finding the root.
     *
     * @param value - value for root operation
     * @param degree - degree for root operation
     * @return {@link Calculator#round(double)} - rounded value of root operation
     * @throws ArithmeticException if the root is calculated from a negative number
     */
    public double root(double value, double degree) throws ArithmeticException {
        if (value < 0 && degree % 2 == 0) {
            throw new ArithmeticException("Even root of negative number!");
        }
        int signum = (int) Math.signum(value);
        return round(Math.pow(Math.abs(value), (double) 1 / degree)) * signum;
    }

    /**
     * The method of finding the power.
     *
     * @param value - value for power operation
     * @param degree - degree for power operation
     * @return {@link Calculator#round(double)} - rounded value of power operation
     */
    public double power(double value, double degree) {
        return round(Math.pow(value, degree));
    }

    /**
     * The method for rounding value with given accuracy.
     *
     * @param value - value for round operation
     * @return {@link Math#round(double)} - rounded value
     */
    public double round(double value) {
        int accuracyCoefficient = (int) Math.pow(10, roundingAccuracy);
        return (double) Math.round(value * accuracyCoefficient) / accuracyCoefficient;
    }
}
