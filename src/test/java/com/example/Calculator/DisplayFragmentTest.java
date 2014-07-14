package com.example.Calculator;

import com.support.Assert.FragmentUtil;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class DisplayFragmentTest extends TestCase {

    @Test
    public void shouldNotBeNull() throws Exception{
        DisplayFragment fragment = new DisplayFragment();
        FragmentUtil.startFragment( fragment);
        assertNotNull( fragment );
    }
}