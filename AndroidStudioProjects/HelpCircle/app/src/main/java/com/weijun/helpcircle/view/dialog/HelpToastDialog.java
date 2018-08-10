package com.weijun.helpcircle.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.weijun.helpcircle.R;

public class HelpToastDialog extends Dialog {
    private Context context;

    public HelpToastDialog(@NonNull Context context, int resId) {
        super(context, R.style.Transparent);
        init(context, resId);
    }


    public void setText(int resId, String msg) {
        View tv = findViewById(resId);
        if (!(tv instanceof TextView)) {
            throw new RuntimeException("必须为TextView");
        }
        ((TextView) tv).setText(msg);
    }

    public void setImage(int resId, int drawableId) {
        View iv = findViewById(resId);
        if (iv instanceof ImageView) {
            ((ImageView) iv).setImageResource(drawableId);
        } else {
            throw new RuntimeException("必须为ImageView");
        }
    }

    private void init(Context context, int resId) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resId, null, false);
        getWindow().setDimAmount(0f);
        setContentView(view);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = ScreenUtils.getScreenWidth() - SizeUtils.dp2px(140);
        lp.height = lp.width * 120 / 235;
        getWindow().setAttributes(lp);
    }

    public void showAndAutoDismiss() {
        show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 1000);
    }
}
