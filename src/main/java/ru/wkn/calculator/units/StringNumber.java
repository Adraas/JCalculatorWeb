package ru.wkn.calculator.units;

public class StringNumber {

    private String integerPart;
    private String fractionalPart;
    private boolean firstInput;
    private boolean dotEntered;
    private boolean fractionalPartEntered;

    public StringNumber() {
        integerPart = "0";
        fractionalPart = "";
        firstInput = true;
        dotEntered = false;
        fractionalPartEntered = false;
    }

    public StringNumber(String defaultValue) {
        setValueByString(defaultValue);
    }

    public void addToIntegerPart(char digit) {
        if (firstInput) {
            if (digit != (int) '0') {
                integerPart = String.valueOf(digit);
                firstInput = false;
            }
        } else {
            integerPart = integerPart.concat(String.valueOf(digit));
        }
    }

    public void addToFractionalPart(char digit) {
        fractionalPart = fractionalPart.concat(String.valueOf(digit));
        if (!fractionalPartEntered) {
            fractionalPartEntered = true;
        }
    }

    public boolean isDotEntered() {
        return dotEntered;
    }

    public void inputDot() {
        dotEntered = true;
    }

    public void setValueByString(String newValue) {
        firstInput = false;
        String[] valueAsStringArray = newValue.split("\\.");
        integerPart = valueAsStringArray[0];
        if (valueAsStringArray.length == 2 && !valueAsStringArray[1].equals("0")) {
            fractionalPart = valueAsStringArray[1];
            fractionalPartEntered = true;
            dotEntered = true;
        } else {
            fractionalPart = "";
            fractionalPartEntered = false;
            dotEntered = false;
        }
    }

    public String getNumberAsString() {
        String numberAsString = integerPart;
        if (dotEntered && fractionalPartEntered) {
            numberAsString = numberAsString.concat(".").concat(fractionalPart);
        }
        return numberAsString;
    }
}
