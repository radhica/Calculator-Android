package com.example.Calculator;

import com.example.Events.BaseEvent;

/**
 * Created by rsampath on 7/16/14.
 */
public class TestButtonFragment extends  ButtonFragment{
    private BaseEvent event;

    @Override
    public void postToBus( BaseEvent event )
    {
        this.event = event;
    }

     BaseEvent getEvent()
    {
        return event;
    }


}
