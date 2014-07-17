package com.example.Calculator;

import android.widget.Button;
import android.widget.TextView;
import com.example.Events.BaseEvent;
import com.example.Events.NumberButtonEvent;
import com.support.Assert.FragmentUtil;
import com.support.Assert.ResourceLocator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.support.Assert.Assert.assertViewIsVisible;
import static com.support.Assert.ResourceLocator.getString;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by rsampath on 7/14/14.
 */

@RunWith(RobolectricTestRunner.class)
public class ButtonFragmentTest  {

    private TestButtonFragment buttonFragment;

    @Before
    public void setUp() throws Exception
    {
        buttonFragment = new TestButtonFragment();
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
                equalTo( getString(R.string.key1) ) );
    }

    @Test
    public void shouldHaveAllKeys() throws Exception {

        int[] keys = new int[]{R.id.key0, R.id.key1, R.id.key2, R.id.key3, R.id.key4, R.id.key5, R.id.key6, R.id.key7, R.id.key8,
                R.id.key9, R.id.keyAdd, R.id.keySub, R.id.keyMul, R.id.keyDiv, R.id.keyMod, R.id.keyClear, R.id.keyEqual};
        for (int i = 0; i < keys.length; i++) {
            assertViewIsVisible(buttonFragment.getView().findViewById(keys[i]));

            int[] numbers = new int[]{R.id.key0, R.id.key1, R.id.key2, R.id.key3, R.id.key4, R.id.key5, R.id.key6, R.id.key7, R.id.key8,
                    R.id.key9};

        /*String [] symbols = new String[]{"零", "一","二","三","四","五","六","七","八","九"};
            for(int j = 0; j< symbols.length; j++){
                TextView key = (TextView) buttonFragment.getView().findViewById( numbers[j] );
                assertThat(key.getText().toString(),equalTo(symbols[j]));

            }
*/
        }
    }

     @Test
     public void oneShouldPostEvent() throws Exception {

            int[] numbers = new int[]{R.id.key0,R.id.key1,R.id.key2,R.id.key3,R.id.key4,R.id.key5,R.id.key6,R.id.key7,
                    R.id.key8, R.id.key9};
         int[] values = new int[]{R.string.key0,R.string.key1,R.string.key2,R.string.key3,R.string.key4,R.string.key5,R.string.key6,R.string.key7,R.string.key8, R.string.key9};


         for(int i = 0 ; i < numbers.length; i++) {
                Button numberKey = (Button) buttonFragment.getView().findViewById(numbers[i]);
                numberKey.performClick();
                verifyNumberButtonEvent(values[i]);
            }

         int[] operators = new int [] {R.id.keyAdd,R.id.keySub,R.id.keyMul,R.id.keyDiv,R.id.keyMod,R.id.keyClear,
                 R.id.keyEqual};
         int[] operatorValues = new int [] {R.string.keyAdd,R.string.keySub,R.string.keyMul,R.string.keyDiv,R.string.keyMod,R.string.keyClear,R.string.keyEqual};


         for(int i = 0 ; i < operators.length; i++) {
             Button operatorKey = (Button) buttonFragment.getView().findViewById(operators[i]);
             operatorKey.performClick();
             verifyNumberButtonEvent(operatorValues[i]);
         }
      }

        private void verifyNumberButtonEvent(int id)
        {
            BaseEvent event = buttonFragment.getEvent();
            assertTrue( event instanceof NumberButtonEvent);
            assertThat( ( (NumberButtonEvent) event ).getNumber(),
                    equalTo( getString(id) ) );
        }

    }

