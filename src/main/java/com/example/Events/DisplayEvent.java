package com.example.Events;

import com.example.Calculator.DisplayFragment;

/**
 * Created by rsampath on 7/17/14.
 */
public class DisplayEvent extends BaseEvent {
    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    String displayText;
        public DisplayEvent(String s){
            this.displayText = s;
        }


}
