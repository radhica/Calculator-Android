package com.support.Assert;

import android.graphics.drawable.Drawable;
import org.robolectric.Robolectric;

/**
 * Created by rsampath on 7/14/14.
 */
public class ResourceLocator {

    public static String getString( int stringId )
    {
        return Robolectric.application
                .getString( stringId );
    }

    public static Drawable getDrawable( int drawableId )
    {
        return Robolectric.application
                .getResources()
                .getDrawable( drawableId );
    }
}
