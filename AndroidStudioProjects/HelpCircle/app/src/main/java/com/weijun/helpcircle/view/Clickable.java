package com.weijun.helpcircle.view;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.weijun.helpcircle.R;

public class Clickable extends ClickableSpan {

    private final View.OnClickListener listener;
    private int color;

    public Clickable(View.OnClickListener listener) {
        this.listener = listener;
    }

    public Clickable(View.OnClickListener listener, int color) {
        this.listener = listener;
        this.color = color;
    }

    @Override
    public void onClick(View view) {
        listener.onClick(view);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
        if (color == 0) {
            color = Color.parseColor("#FF395F91");
        }
        ds.setColor(color);
    }
}
