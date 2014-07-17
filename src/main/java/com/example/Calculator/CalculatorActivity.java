package com.example.Calculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Events.NumberButtonEvent;
import com.example.Events.OperatorButtonEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.concurrent.Phaser;

public class CalculatorActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final String TAG = "Lifecycle "
            + CalculatorActivity.class.getSimpleName();

    public static final String CALCULATOR_STATE_FRAGMENT_TAG = "calculator state";

    private CalculatorState calculatorState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d(TAG, "onCreate()");

        getFragmentManager()
                .beginTransaction()
                .add(new CalculatorStateFragment(),
                        CALCULATOR_STATE_FRAGMENT_TAG).commit();
        calculatorState = new CalculatorState();
    }

    /**
     * Handles the selection of a number.
     *
     * @param event - number entered
     */
    @Subscribe
    public void onNumberSelected(NumberButtonEvent event) {

        Toast.makeText(this, "Clicked: " + event.getNumber(),
                Toast.LENGTH_SHORT).show();

        CalculatorState calState = this.calculatorState;

        if (calState.getPreviousOperator() == ' ') {
            calState.setPreviousNumber(calState.getPreviousNumber()
                    + event.getNumber());
            calState.setDisplayText(calculatorState.getPreviousNumber());
        } else {
            calState.setCurrentNumber(calState.getCurrentNumber()
                    + event.getNumber());
        }
        //call fragment to display number

        this.calculatorState = calState;
    }

    /**
     * Handles the selection of a operator.
     *
     * @param event - operator entered
     */
    @Subscribe
    public void onOperatorSelected(OperatorButtonEvent event) {

        Toast.makeText(this, "Clicked: " + event.getOperator(),
                Toast.LENGTH_SHORT).show();
        performOperation(event.getOperator().charAt(0));
    }

    private void performOperation(char operator) {
        CalculatorState calState = this.calculatorState;


        if(operator == 'C'){
            this.calculatorState = new CalculatorState();
            return;
        }

        if (calState.getPreviousOperator() == ' ') {
            if (operator != '=') {
                calState.setPreviousOperator(operator);
                //calState.setDisplayText(calState.getPreviousNumber());
                return;
            } else {
                return;
            }
        }

        if (calState.getPreviousNumber().equalsIgnoreCase("")
                || calState.getCurrentNumber().equalsIgnoreCase("")) {
            return;
        }
        String prevNumber = new String();
        //calState.setDisplayText(calculatorState.getPreviousNumber());
        switch (calState.getPreviousOperator()) {
            case '+':
                prevNumber = CalculatorApplication.add(
                        calState.getPreviousNumber(), calState.getCurrentNumber());
                break;
            case '-':
                prevNumber = CalculatorApplication.subtract(
                        calState.getPreviousNumber(), calState.getCurrentNumber());
                break;
            case '*':
                prevNumber = CalculatorApplication.multiply(
                        calState.getPreviousNumber(), calState.getCurrentNumber());
                break;
            case '/':
                prevNumber = CalculatorApplication.divide(
                        calState.getPreviousNumber(), calState.getCurrentNumber());
                break;
            case '%':
                prevNumber = CalculatorApplication.modulo(
                        calState.getPreviousNumber(), calState.getCurrentNumber());
                break;
            default:
                break;
        }
        calState.setPreviousNumber(prevNumber);

        if (operator != '=') {
            calState.setPreviousOperator(operator);

        } else {
            calState.setPreviousOperator(' ');
        }
        calState.setCurrentNumber(new String());
        //call fragment to display previous number

        this.calculatorState = calState;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");

        getBus().register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");

        getBus().unregister(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    protected Bus getBus() {
        return CalculatorApplication.getInstance().getBus();
    }
}