package com.example.Calculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.example.Events.DisplayEvent;
import com.squareup.otto.Subscribe;

/**
 * Created by rsampath on 7/14/14.
 */
public class DisplayFragment extends BaseFragment {
    private static final String TAG = "Lifecycle " + DisplayFragment.class.getSimpleName();
    private View layout;
    private EditText output;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.display,container, false);
        output = (EditText)layout.findViewById(R.id.display);
        Log.d(TAG, "onCreateView()");
        return layout;
    }


    @Subscribe
    public void onDisplayEvent(DisplayEvent event) {
        Toast.makeText(getActivity(), "Display: " + event.getDisplayText(),
                Toast.LENGTH_SHORT).show();
     /*   if (output.getText().toString().equals("C"))
            output.setText();
        else*/
            output.setText(event.getDisplayText());

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
