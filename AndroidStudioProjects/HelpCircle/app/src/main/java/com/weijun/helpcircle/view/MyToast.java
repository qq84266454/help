package com.weijun.helpcircle.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blankj.utilcode.util.ScreenUtils;
import com.weijun.helpcircle.R;

public class MyToast {
    private Toast mToast;

    public MyToast(Context context, CharSequence text, int duration) {
        View v = LayoutInflater.from(context).inflate(R.layout.dialog_help_success, null, false);
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
    }

    public static MyToast makeText(Context context, CharSequence text, int duration) {
        return new MyToast(context, text, duration);
    }

    public void show() {
        if (mToast != null) {
            ViewGroup.LayoutParams layoutParams = mToast.getView().getLayoutParams();
            layoutParams.width = ScreenUtils.getScreenWidth() - 140;
            mToast.getView().setLayoutParams(layoutParams);
            mToast.show();
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }

    public Toast setGravity(int gravity) {
        if (mToast != null) {
            mToast.setGravity(gravity, 0, 0);
        }
        return mToast;
    }
}