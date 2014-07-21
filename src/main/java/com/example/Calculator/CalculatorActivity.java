package com.example.Calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.Events.DisplayEvent;
import com.example.Events.NumberButtonEvent;
import com.example.Events.OperatorButtonEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;


public class CalculatorActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final String TAG = "Lifecycle "
            + CalculatorActivity.class.getSimpleName();

    public static final String CALCULATOR_STATE_FRAGMENT_TAG = "calculator state";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d(TAG, "onCreate()");



        if(getResources().getDisplayMetrics().widthPixels>getResources().getDisplayMetrics().
                heightPixels)
        {
            Toast.makeText(this,"Screen switched to Landscape mode",Toast.LENGTH_SHORT).
                    show();
        }
        else
        {
            Toast.makeText(this,"Screen switched to Portrait mode",Toast.LENGTH_SHORT).
                    show();
        }

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

        CalculatorState calState = CalculatorApplication.getInstance().getCalculatorState();

        if (calState.getPreviousOperator() == ' ') {
            calState.setPreviousNumber(calState.getPreviousNumber()
                    + event.getNumber());
            CalculatorApplication.postToBus(new DisplayEvent(calState.getPreviousNumber()));
        } else {
            calState.setCurrentNumber(calState.getCurrentNumber()
                    + event.getNumber());
            CalculatorApplication.postToBus(new DisplayEvent(calState.getCurrentNumber()));
        }

        CalculatorApplication.getInstance().setCalculatorState(calState);
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
        if(event.getOperator().toString().equals("C"))
            CalculatorApplication.postToBus(new DisplayEvent(" "));
        else
            CalculatorApplication.postToBus(new DisplayEvent(event.getOperator()));
        performOperation(event.getOperator().charAt(0));

    }

    private void performOperation(char operator) {
        CalculatorState calState = CalculatorApplication.getInstance().getCalculatorState();


        if(operator == 'C'){
            CalculatorApplication.getInstance().setCalculatorState(new CalculatorState());
            return;
        }


        if (calState.getPreviousOperator() == ' ') {
            if (operator != '=') {
                calState.setPreviousOperator(operator);
                return;
            } else {
                CalculatorApplication.postToBus(new DisplayEvent(calState.getPreviousNumber()));
                return;
            }
        }

        if(calState.getEqualPressed() && operator != '='){
            calState.setCurrentNumber(new String());
            calState.setEqualPressed(false);
            calState.setPreviousOperator(operator);
            return;
        }

        if (calState.getPreviousNumber().equalsIgnoreCase("")
                || calState.getCurrentNumber().equalsIgnoreCase("")) {
            return;
        }

        String prevNumber = operation(calState);
        CalculatorApplication.postToBus(new DisplayEvent(prevNumber));
        calState.setPreviousNumber(prevNumber);
        if (operator != '=') {
            calState.setPreviousOperator(operator);
            calState.setCurrentNumber(new String());
        }
        else{
            calState.setEqualPressed(true);
            calState.setPreviousOperator(calState.getPreviousOperator());
        }

        CalculatorApplication.getInstance().setCalculatorState(calState);
    }

    private String operation(CalculatorState calState){
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
        return prevNumber;
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