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
