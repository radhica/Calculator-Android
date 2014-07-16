package com.example.Calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class CalculatorActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final String TAG = "Lifecycle " + CalculatorActivity.class.getSimpleName();

    public static final String CALCULATOR_STATE_FRAGMENT_TAG = "calculator state";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d(TAG,"onCreate()");

        getFragmentManager().beginTransaction()
                .add( new CalculatorStateFragment(),
                        CALCULATOR_STATE_FRAGMENT_TAG )
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}
