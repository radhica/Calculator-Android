package com.example.Events;

/**
 * Created by rsampath on 7/16/14.
 */
public class OperatorButtonEvent extends BaseEvent{

    String operator;

    public OperatorButtonEvent( String operator )
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
}
