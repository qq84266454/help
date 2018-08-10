package com.weijun.helpcircle.view.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;

/**
 * Created by LoveAndPeace on 2017/11/20.
 */

public class BottomPopup extends PopupWindow implements View.OnClickListener {
    private final BaseActivity activity;
    private View view;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemOneClick();

        void onItemTwoClick();

        void onItemCancelClick();
    }

    public BottomPopup(BaseActivity activity) {
        this.activity = activity;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.pop_action_sheet, null);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
        this.setFocusable(true);
        this.setAnimationStyle(R.style.animBottom);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                light(1f);
            }
        });
    }

    public BottomPopup(BaseActivity activity, OnItemClickListener listener) {
        this(activity);
        this.listener = listener;
    }


    public void show(View anchor) {
        this.showAtLocation(anchor, Gravity.BOTTOM, 0, 0);
        light(0.5f);
    }

    public void light(float bgFloat) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgFloat;
        activity.getWindow().setAttributes(lp);
    }


    public void onClick(View view) {
        if (listener != null) {
            switch (view.getId()) {
                case R.id.mTvOne:
                    listener.onItemOneClick();
                    break;
                case R.id.mTvTwo:
                    listener.onItemTwoClick();
                    break;
                case R.id.mTvCancel:
                    listener.onItemCancelClick();
                    break;
            }
        }
    }


}
