package com.example.Calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by rsampath on 7/15/14.
 */

@RunWith(RobolectricTestRunner.class)
public class CalculatorApplicationTest {

    private CalculatorApplication application;

    @Before
    public void setUp() throws Exception
    {
        application = CalculatorApplication.getInstance();
    }

    @Test
    public void shouldNotBeNull() throws Exception{
        assertNotNull(CalculatorApplication.getInstance());
    }

    @Test
    public void shouldHaveBus() throws Exception
    {
        assertNotNull( application.getBus() );
    }
}
