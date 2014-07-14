package com.example.Calculator;

import com.support.Assert.FragmentUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by rsampath on 7/14/14.
 */

@RunWith(RobolectricTestRunner.class)
public class ButtonFragmentTest {

    @Test
    public void shouldNotBeNull() throws Exception{
        ButtonFragment fragment = new ButtonFragment();
        FragmentUtil.startFragment(fragment);
        assertNotNull( fragment );
    }
}
