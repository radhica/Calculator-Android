package com.example.Events;

/**
 * Created by rsampath on 7/16/14.
 */
public class NumberButtonEvent extends BaseEvent {

    String number;

    public NumberButtonEvent( String number )
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }
}
