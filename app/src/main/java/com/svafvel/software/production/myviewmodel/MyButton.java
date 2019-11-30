package com.svafvel.software.production.myviewmodel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class MyButton extends AppCompatButton {

    private Drawable enableBackground, disabledBackground;
    private int textColor;

    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        setBackground(isEnabled() ? enableBackground : disabledBackground);
        setTextColor(textColor);
        setTextSize(12.f);
        setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        setText(isEnabled() ? "Submit" : "Isi Dulu");
    }

    private void init(){

        textColor = ContextCompat.getColor(getContext(), android.R.color.background_light);
        enableBackground = getResources().getDrawable(R.drawable.bg_button);
        disabledBackground = getResources().getDrawable(R.drawable.bg_button_disable);

    }


}
