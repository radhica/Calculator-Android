package com.example.Calculator;

import android.widget.TextView;
import com.support.Assert.FragmentUtil;
import com.support.Assert.ResourceLocator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.support.Assert.Assert.assertViewIsVisible;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by rsampath on 7/14/14.
 */

@RunWith(RobolectricTestRunner.class)
public class ButtonFragmentTest {

    private ButtonFragment buttonFragment;

    @Before
    public void setUp() throws Exception
    {
        buttonFragment = new ButtonFragment();
        FragmentUtil.startFragment(buttonFragment);
    }

    @Test
    public void shouldNotBeNull() throws Exception{
       // ButtonFragment fragment = new ButtonFragment();
        //FragmentUtil.startFragment(fragment);
        assertNotNull( buttonFragment );
    }

    @Test
    public void shouldHaveOneKey() throws Exception
    {
        /*assertViewIsVisible( buttonFragment.getView()
                .findViewById( R.id.key1 ) );*/
        verifyOneKey();


    }
    @Test
    @Config(qualifiers = "ja")
    public void shouldHaveJapaneseKeys()
    {
        int[] keys = new int[]{R.id.key0,R.id.key1,R.id.key2,R.id.key3,R.id.key4,R.id.key5,R.id.key6,R.id.key7,R.id.key8,
                R.id.key9,R.id.keyAdd,R.id.keySub,R.id.keyMul,R.id.keyDiv,R.id.keyMod,R.id.keyClear,R.id.keyEqual};
        for (int i = 0; i < keys.length; i++) {
            assertViewIsVisible(buttonFragment.getView().findViewById(keys[i]));
        }
    }

    private void verifyOneKey()
    {
        TextView key1 = (TextView) buttonFragment.getView().findViewById( R.id.key1 );
        assertViewIsVisible( key1 );
        assertThat( key1.getText().toString(),
                equalTo( ResourceLocator.getString(R.string.key1) ) );
    }

    @Test
    public void shouldHaveAllKeys() throws Exception {

        int[] keys = new int[]{R.id.key0,R.id.key1,R.id.key2,R.id.key3,R.id.key4,R.id.key5,R.id.key6,R.id.key7,R.id.key8,
                R.id.key9,R.id.keyAdd,R.id.keySub,R.id.keyMul,R.id.keyDiv,R.id.keyMod,R.id.keyClear,R.id.keyEqual};
        for ( int i =0; i< keys.length;i++) {
            assertViewIsVisible(buttonFragment.getView().findViewById(keys[i]));

        int[] numbers = new int[]{R.id.key0,R.id.key1,R.id.key2,R.id.key3,R.id.key4,R.id.key5,R.id.key6,R.id.key7,R.id.key8,
                    R.id.key9};

        String [] symbols = new String[]{"零", "一","二","三","四","五","六","七","八","九"};
            for(int j = 0; j< symbols.length; j++){
                TextView key = (TextView) buttonFragment.getView().findViewById( numbers[j] );
                assertThat(key.getText().toString(),equalTo(symbols[j]));

            }
        }




    }
}
