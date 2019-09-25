package com.biton.rut.cosmetician_app.custom_view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by kuldeep on 18/01/18.
 */

public class MyCustomEditText extends AppCompatEditText {

    public MyCustomEditText(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"Fonts/Roboto-Regular.ttf"));
    }
}
