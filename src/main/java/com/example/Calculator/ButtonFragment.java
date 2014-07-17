package com.example.Calculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.Events.NumberButtonEvent;
import com.example.Events.OperatorButtonEvent;

import static com.example.Calculator.CalculatorApplication.postToBus;

/**
 * Created by rsampath on 7/14/14.
 */
public class ButtonFragment extends BaseFragment
{
    private static final String TAG = "LIFECYCLE" + ButtonFragment.class.getSimpleName();
    private View layout;

    private void configureNumberKeys(){
        int[] keys = new int[]{R.id.key0,R.id.key1,R.id.key2,R.id.key3,R.id.key4,R.id.key5,R.id.key6,R.id.key7,R.id.key8,
                R.id.key9};
        for(int i = 0; i < keys.length; i++)
            configureNumberKey(keys[i]);
    }

    private void configureNumberKey( int id )
    {
        layout.findViewById( id )
                .setOnClickListener( createNumberOnClickListener() );
    }

    private View.OnClickListener createNumberOnClickListener()
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                String number = ((Button) view).getText().toString();
                postToBus( new NumberButtonEvent( number ) );
            }
        };
    }

    private void configureOperatorKeys(){
        int[] keys = new int[]{R.id.keyAdd,R.id.keySub,R.id.keyMul,R.id.keyDiv,R.id.keyMod,R.id.keyClear,R.id.keyEqual};
        for(int i = 0; i < keys.length; i++)
            configureOperatorKey(keys[i]);
    }

    private void configureOperatorKey( int id )
    {
        layout.findViewById( id )
                .setOnClickListener( createOperatorOnClickListener() );
    }

    private View.OnClickListener createOperatorOnClickListener()
    {
        return  new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String operator = ((Button) view).getText().toString();
                postToBus( new OperatorButtonEvent( operator ) );
            }
        };
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG,"onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        layout = inflater.inflate( R.layout.buttons,container,false );

        Log.d(TAG, "onCreateView()");

        configureNumberKeys();
        configureOperatorKeys();
        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach()");
    }
}