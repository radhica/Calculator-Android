package com.example.Events;

import com.example.Calculator.DisplayFragment;

/**
 * Created by rsampath on 7/17/14.
 */
public class DisplayEvent extends BaseEvent {

    String displayText;

    public DisplayEvent(String s){

        this.displayText = s;
        if(s.charAt(0)=='0' && s.length() > 1)
            this.displayText = s.substring(1);

        }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }



}
