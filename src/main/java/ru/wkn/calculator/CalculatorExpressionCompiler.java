package ru.wkn.calculator;

import ru.wkn.calculator.calculating.Calculator;
import ru.wkn.calculator.units.StringExpression;
import ru.wkn.calculator.units.StringNumber;

public class CalculatorExpressionCompiler {

    private StringNumber firstOperand;
    private StringNumber secondOperand;
    private StringExpression stringExpression;
    private Calculator calculator;
    private char currentOperator;
    private boolean operandsUpdated;

    public CalculatorExpressionCompiler(Calculator calculator) {
        this.calculator = calculator;
        allClear();
    }

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

    private String valueAfterAddingDigit(char inputDigit) {
        operandsUpdated = false;
        if (!secondOperand.isDotEntered()) {
            secondOperand.addToIntegerPart(inputDigit);
        } else {
            secondOperand.addToFractionalPart(inputDigit);
        }
        return secondOperand.getNumberAsString();
    }

    private String valueAfterInputDot() {
        operandsUpdated = false;
        secondOperand.inputDot();
        return secondOperand.getNumberAsString();
    }

    private void operandsUpdate() {
        operandsUpdated = true;
        stringExpression.setFirstOperand(firstOperand);
        stringExpression.setSecondOperand(secondOperand);
        stringExpression.setOperator(currentOperator);
        firstOperand.setNumberAsString(stringExpression.getAnswerAsString());
        secondOperand = new StringNumber();
    }

    public void allClear() {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        stringExpression = new StringExpression(calculator);
        currentOperator = '+';
        operandsUpdated = false;
    }
}
