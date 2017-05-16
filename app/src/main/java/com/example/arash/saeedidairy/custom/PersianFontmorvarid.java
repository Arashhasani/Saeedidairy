package com.example.arash.saeedidairy.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Arash on 4/18/2017.
 */

public class PersianFontmorvarid extends TextView {
    public PersianFontmorvarid(Context context) {
        super(context);
        font();
    }

    public PersianFontmorvarid(Context context, AttributeSet attrs) {
        super(context, attrs);
        font();
    }

    public PersianFontmorvarid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        font();
    }
    public void font(){
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"morvarid.ttf");
        setTypeface(tf);
    }
}
