package com.example.Calculator;

/**
 * Created by rsampath on 7/17/14.
 */
public class CalculatorState {
    private String previousNumber;
    private String currentNumber;
    private char currentOperator;
    private char previousOperator;


    private String displayText;

    CalculatorState(){
        previousNumber = new String();
        currentNumber = new String();
        setCurrentOperator(' ');
        setPreviousOperator(' ');
    }

    public String getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(String currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getPreviousNumber() {
        return previousNumber;
    }

    public void setPreviousNumber(String previousNumber) {
        this.previousNumber = previousNumber;
    }

    public char getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(char currentOperator) {
        this.currentOperator = currentOperator;
    }

    public void setPreviousOperator(char previousOperator) {
        this.previousOperator = previousOperator;
    }

    public char getPreviousOperator() {
        return previousOperator;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

}
