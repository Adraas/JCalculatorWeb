package ru.wkn.calculator.units;

/**
 * The class for string representation of a number.
 * @author Pikalov Artem.
 */
public class StringNumber {

    /**
     * The string representation of integer part of value.
     */
    private String integerPart;

    /**
     * The string representation of fractional part of value.
     */
    private String fractionalPart;

    /**
     * The determinant of first input.
     */
    private boolean firstInput;

    /**
     * The determinant of dot existence in value.
     */
    private boolean dotEntered;

    /**
     * The determinant of existence fractional part in value.
     */
    private boolean fractionalPartEntered;

    /**
     * Initializes a newly created {@code StringNumber} object with property values by-default.
     *
     * @see StringNumber#StringNumber(String)
     */
    public StringNumber() {
        integerPart = "0";
        fractionalPart = "";
        firstInput = true;
        dotEntered = false;
        fractionalPartEntered = false;
    }

    /**
     * Initializes a newly created {@code StringNumber} object with given value.
     *
     * @param defaultValue - the given value for string representation of a number
     * @see StringNumber#StringNumber()
     */
    public StringNumber(String defaultValue) {
        setNumberAsString(defaultValue);
    }

    /**
     * The method to adding an integer part into {@link StringNumber#integerPart}.
     *
     * @param digit - new digit symbol for adding
     */
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

    /**
     * The method to adding a fractional part into {@link StringNumber#fractionalPart}.
     *
     * @param digit - new digit symbol for adding
     */
    public void addToFractionalPart(char digit) {
        fractionalPart = fractionalPart.concat(String.valueOf(digit));
        if (!fractionalPartEntered) {
            fractionalPartEntered = true;
        }
    }

    /**
     * The method to get the field {@link StringNumber#dotEntered} value.
     *
     * @return {@code true} if dot was entered; {@code false} otherwise
     */
    public boolean isDotEntered() {
        return dotEntered;
    }

    /**
     * The method to initiate a dot entering.
     */
    public void inputDot() {
        dotEntered = true;
    }

    /**
     * The method of identification for string representation value.
     *
     * @param newValue - value as {@code Number}
     * @see StringNumber#setNumberAsString(String)
     */
    public void setNumberAsString(Number newValue) {
        setNumberAsString(String.valueOf(newValue));
    }

    /**
     * The method of identification for string representation value.
     *
     * @param newValue - value as {@code String}
     * @see StringNumber#setNumberAsString(Number)
     */
    public void setNumberAsString(String newValue) {
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

    /**
     * The method to get the string representation of value.
     *
     * @return string representation of the value
     */
    public String getNumberAsString() {
        String numberAsString = integerPart;
        if (dotEntered && fractionalPartEntered) {
            numberAsString = numberAsString.concat(".").concat(fractionalPart);
        }
        return numberAsString;
    }
}
