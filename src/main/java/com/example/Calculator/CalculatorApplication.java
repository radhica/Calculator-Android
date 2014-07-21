package com.example.Calculator;
import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import com.example.Events.BaseEvent;
import com.squareup.otto.Bus;

/**
 * Created by rsampath on 7/15/14.
 */
public class CalculatorApplication extends Application{

    private static CalculatorApplication instance = new CalculatorApplication();
    private Bus bus;
    private static final String TAG = "Lifecycle " + CalculatorApplication.class.getSimpleName();
    private CalculatorState calculatorState;
    /*private CalculatorApplication() // singleton class
    {

    }*/

    public Bus getBus()
    {
        return bus;
    }
    public CalculatorState getCalculatorState(){
        return calculatorState;
    }

    public void setCalculatorState(CalculatorState calcSate){
        instance.calculatorState = calcSate;
    }

    public static void postToBus(BaseEvent event)
    {
        getInstance().getBus().post(event);
    }

    public static String add(String operand1, String operand2 ){
        return String.valueOf(Integer.parseInt(operand1) + Integer.parseInt(operand2));
    }

    public static String subtract(String operand1, String operand2 ){
        return String.valueOf(Integer.parseInt(operand1) - Integer.parseInt(operand2));
    }

    public static String multiply(String operand1, String operand2 ){
        return String.valueOf(Integer.parseInt(operand1) * Integer.parseInt(operand2));
    }

    public static String divide(String operand1, String operand2 ){
        if (operand2.equals("0"))
            return "ERROR";
        return String.valueOf(Integer.parseInt(operand1) / Integer.parseInt(operand2));
    }

    public static String modulo(String operand1, String operand2 ){
        return String.valueOf(Integer.parseInt(operand1) % Integer.parseInt(operand2));
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance.bus = new Bus();
        instance.calculatorState = new CalculatorState();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG,"onConfigurationChanged()");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "onLowMemory()");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d(TAG,"onTrimMemory()");
    }

    public static CalculatorApplication getInstance()
    {
        return instance;
    }
}