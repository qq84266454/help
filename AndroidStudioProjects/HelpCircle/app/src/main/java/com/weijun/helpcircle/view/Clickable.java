package com.weijun.helpcircle.view;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.weijun.helpcircle.R;

public class Clickable extends ClickableSpan {

    private final View.OnClickListener listener;

    public Clickable(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        listener.onClick(view);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
        ds.setColor(Color.parseColor("#FF395F91"));
    }
}
