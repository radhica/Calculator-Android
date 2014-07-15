package com.example.Calculator;

import android.app.Application;
import com.example.Events.BaseEvent;
import com.squareup.otto.Bus;

/**
 * Created by rsampath on 7/15/14.
 */
public class CalculatorApplication extends Application{

    private static CalculatorApplication instance = new CalculatorApplication();
    private Bus bus;

    /*private CalculatorApplication() // singleton class
    {

    }*/

    public Bus getBus()
    {
        return bus;
    }

    public static void postToBus(BaseEvent event)
    {
        getInstance().getBus().post(event);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance.bus = new Bus();
    }

    public static CalculatorApplication getInstance()
    {
        return instance;
    }
}
