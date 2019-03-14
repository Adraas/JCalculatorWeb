package ru.wkn.calculator.units;

import ru.wkn.calculator.calculating.Calculator;

/**
 * The class for string representation of arithmetic expression.
 * @author Pikalov Artem.
 */
public class StringExpression {

    /**
     * The string representation of first operand of expression.
     */
    private StringNumber firstOperand;

    /**
     * The string representation of second operand of expression.
     */
    private StringNumber secondOperand;

    /**
     * The char representation of operator of expression.
     */
    private char operator;

    /**
     * The {@link Calculator} object for arithmetic operations.
     */
    private Calculator calculator;

    /**
     * Initializes a newly created {@code StringExpression} object with given {@link Calculator} object value.
     *
     * @param calculator - the given {@link Calculator} object value
     */
    public StringExpression(Calculator calculator) {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        this.calculator = calculator;
    }

    /**
     * The method of identification for string representation of {@link StringExpression#firstOperand}.
     *
     * @param firstOperand - string representation of number
     */
    public void setFirstOperand(StringNumber firstOperand) {
        this.firstOperand = firstOperand;
    }

    /**
     * The method of identification for string representation of {@link StringExpression#secondOperand}.
     *
     * @param secondOperand - string representation of number
     */
    public void setSecondOperand(StringNumber secondOperand) {
        this.secondOperand = secondOperand;
    }

    /**
     * The method of identification for char representation of {@link StringExpression#operator}.
     *
     * @param operator - char representation of operator
     */
    public void setOperator(char operator) {
        this.operator = operator;
    }

    /**
     * The method to get the string representation for answer of the given expression.
     *
     * @return string representation for answer of the given expression
     * @throws ArithmeticException if there is a root calculate from a negative number
     *                             or an attempt to divide by zero
     */
    public String getAnswerAsString() throws ArithmeticException {
        String operationAnswerAsString = firstOperand.getNumberAsString();
        double firstOperand = Double.parseDouble(this.firstOperand.getNumberAsString());
        double secondOperand = Double.parseDouble(this.secondOperand.getNumberAsString());
        if (operator != 0) {
            switch (operator) {
                case '+': {
                    operationAnswerAsString = String.valueOf(calculator.sum(firstOperand, secondOperand));
                    break;
                }
                case '-': {
                    operationAnswerAsString = String.valueOf(calculator.subtract(firstOperand, secondOperand));
                    break;
                }
                case '*': {
                    operationAnswerAsString = String.valueOf(calculator.multiply(firstOperand, secondOperand));
                    break;
                }
                case '/': {
                    operationAnswerAsString = String.valueOf(calculator.division(firstOperand, secondOperand));
                    break;
                }
                case '√': {
                    operationAnswerAsString = String.valueOf(calculator.root(firstOperand, secondOperand));
                    break;
                }
                case '^': {
                    operationAnswerAsString = String.valueOf(calculator.power(firstOperand, secondOperand));
                    break;
                }
                case '=': {
                    operationAnswerAsString = String.valueOf(calculator
                            .round(Double.parseDouble(this.secondOperand.getNumberAsString())));
                    break;
                }
            }
        }
        StringNumber resultValue = new StringNumber(operationAnswerAsString);
        return resultValue.getNumberAsString();
    }
}
