package ru.wkn.calculator;

import ru.wkn.calculator.calculating.Calculator;

public class CalculatorFacade {

    private Calculator calculator;
    private CalculatorExpressionCompiler calculatorExpressionCompiler;

    public CalculatorFacade() {
        calculator = new Calculator(1);
        calculatorExpressionCompiler = new CalculatorExpressionCompiler(calculator);
    }

    public CalculatorFacade(int roundingAccuracy) {
        calculator = new Calculator(roundingAccuracy);
        calculatorExpressionCompiler = new CalculatorExpressionCompiler(calculator);
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public CalculatorExpressionCompiler getCalculatorExpressionCompiler() {
        return calculatorExpressionCompiler;
    }

    public void setCalculatorExpressionCompiler(CalculatorExpressionCompiler calculatorExpressionCompiler) {
        this.calculatorExpressionCompiler = calculatorExpressionCompiler;
    }
}
