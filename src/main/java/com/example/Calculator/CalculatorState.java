package com.example.Calculator;

/**
 * Created by rsampath on 7/17/14.
 */
public class CalculatorState {
    private String previousNumber;
    private String currentNumber;
    private char currentOperator;
    private char previousOperator;
    private boolean equalPressed;


    private String displayText;

    CalculatorState(){
        previousNumber = "0";
        currentNumber = new String();
        setCurrentOperator(' ');
        setPreviousOperator(' ');
        equalPressed = false;
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

    public boolean getEqualPressed(){
        return equalPressed;
    }

    public void setEqualPressed(boolean pressed){
        this.equalPressed = pressed;
    }

}