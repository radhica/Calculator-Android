package com.example.Calculator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)

public class CalculatorActivityTest extends TestCase {

    private CalculatorActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity(CalculatorActivity.class)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveDisplayFragment() throws Exception
    {
        assertNotNull( activity.getFragmentManager()
                .findFragmentById( R.id.display_fragment ) );
    }

    @Test
    public void shouldHaveButtonFragment() throws Exception
    {
        assertNotNull(activity.getFragmentManager().findFragmentById(R.id.button_fragment));
    }

    @Test
    public void shouldHaveCalculatorStateFragment() throws Exception
    {
        assertNotNull( activity.getFragmentManager()
                .findFragmentByTag( CalculatorActivity.CALCULATOR_STATE_FRAGMENT_TAG ) );
    }


}