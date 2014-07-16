package com.example.Calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by rsampath on 7/16/14.
 */

@RunWith(RobolectricTestRunner.class)
public class CalculatorStateFragmentTest {

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( new CalculatorStateFragment() );
    }


}
