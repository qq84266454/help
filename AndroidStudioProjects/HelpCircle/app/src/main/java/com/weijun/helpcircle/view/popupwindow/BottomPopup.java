package com.weijun.helpcircle.view.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.request.target.ThumbnailImageViewTarget;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;

import org.w3c.dom.Text;

import butterknife.OnClick;

/**
 * Created by LoveAndPeace on 2017/11/20.
 */

public class BottomPopup extends PopupWindow {
    private final BaseActivity activity;
    private View view;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemOneClick();

        void onItemTwoClick();

        void onItemCancelClick(BottomPopup popup);
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
        view.findViewById(R.id.mTvOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onItemOneClick();
                dismiss();
            }
        });
        view.findViewById(R.id.mTvTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onItemTwoClick();
                dismiss();
            }
        });
        view.findViewById(R.id.mTvCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onItemCancelClick(BottomPopup.this);
            }
        });
    }

    public BottomPopup(BaseActivity activity, OnItemClickListener listener) {
        this(activity);
        setListener(listener);
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

    public void setText(int resId, String text) {
        ((TextView) view.findViewById(resId)).setText(text);
    }

}
