package com.example.Calculator;

import android.widget.EditText;
import com.support.Assert.FragmentUtil;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static com.support.Assert.Assert.assertViewIsVisible;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(RobolectricTestRunner.class)
public class DisplayFragmentTest extends TestCase {

    private DisplayFragment fragment;
    private EditText display;

    @Before
    public void setUp() throws Exception
    {
        fragment = new DisplayFragment();
        FragmentUtil.startFragment(fragment);
        display = (EditText) fragment.getView().findViewById( R.id.display );
    }

    @Test
    public void shouldNotBeNull() throws Exception{
                 assertNotNull( fragment );
    }

    @Test
    public void shouldHaveDefaultDisplay() throws Exception
    {
        //EditText display = (EditText) fragment.getView().findViewById( R.id.display );
        assertViewIsVisible( display );
        assertThat( display.getText().toString(),
                equalTo( "" ) );
    }
}