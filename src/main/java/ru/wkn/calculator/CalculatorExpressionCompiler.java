package ru.wkn.calculator;

import ru.wkn.calculator.calculating.Calculator;
import ru.wkn.calculator.units.StringExpression;
import ru.wkn.calculator.units.StringNumber;

/**
 * The class for string representation of a number.
 * @author Pikalov Artem.
 */
public class CalculatorExpressionCompiler {

    /**
     * The string representation of first operand of expression.
     */
    private StringNumber firstOperand;

    /**
     * The string representation of second operand of expression.
     */
    private StringNumber secondOperand;

    /**
     * The string representation of arithmetic expression.
     */
    private StringExpression stringExpression;

    /**
     * The {@link Calculator} object for arithmetic operations.
     */
    private Calculator calculator;

    /**
     * The char representation of current operator of expression.
     */
    private char currentOperator;

    /**
     * The determinant of operand updating.
     */
    private boolean operandsUpdated;

    /**
     * Initializes a newly created {@code CalculatorExpressionCompiler}
     * object with given {@link Calculator} object value.
     *
     * @param calculator - the given {@link Calculator} object value
     */
    public CalculatorExpressionCompiler(Calculator calculator) {
        this.calculator = calculator;
        allClear();
    }

    /**
     * The method to get the string representation of current input.
     *
     * @param inputSymbol - current symbol
     * @return the string representation of current input
     * @throws ArithmeticException if there is a root calculate from a negative number
     *                             or an attempt to divide by zero
     */
    public String getCurrentAnswerAsString(char inputSymbol) throws ArithmeticException {
        if (Character.isDigit(inputSymbol)) {
            return valueAfterAddingDigit(inputSymbol);
        }
        if (inputSymbol == '.') {
            return valueAfterInputDot();
        }
        if ("+-*/√^=".contains(String.valueOf(inputSymbol))) {
            if (!operandsUpdated) {
                operandsUpdate();
            }
            currentOperator = inputSymbol;
            return firstOperand.getNumberAsString();
        }
        return firstOperand.getNumberAsString();
    }

    /**
     * The method to get the string representation of value after adding new digit.
     *
     * @param inputDigit - current string representation of digit
     * @return the string representation of value after adding new digit
     */
    private String valueAfterAddingDigit(char inputDigit) {
        operandsUpdated = false;
        if (!secondOperand.isDotEntered()) {
            secondOperand.addToIntegerPart(inputDigit);
        } else {
            secondOperand.addToFractionalPart(inputDigit);
        }
        return secondOperand.getNumberAsString();
    }

    /**
     * The method to get the string representation of value after adding dot into value.
     *
     * @return the string representation of value after adding dot into value
     */
    private String valueAfterInputDot() {
        operandsUpdated = false;
        secondOperand.inputDot();
        return secondOperand.getNumberAsString();
    }

    /**
     * The method to update string representation of operands.
     */
    private void operandsUpdate() {
        operandsUpdated = true;
        stringExpression.setFirstOperand(firstOperand);
        stringExpression.setSecondOperand(secondOperand);
        stringExpression.setOperator(currentOperator);
        firstOperand.setNumberAsString(stringExpression.getAnswerAsString());
        secondOperand = new StringNumber();
    }

    /**
     * The method to clear the string representation of expression and operands.
     */
    public void allClear() {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        stringExpression = new StringExpression(calculator);
        currentOperator = '+';
        operandsUpdated = false;
    }
}
