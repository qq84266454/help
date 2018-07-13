package com.weijun.helpcircle.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * 点击外部事件监听的弹窗类
 * Created by xp.h on 16/10/25.
 */
public class TouchOutsideDialog extends Dialog {
    /**
     * 点击弹窗外部的监听事件
     * @param context 上下文
     */
    private OnTouchOutsideListener onTouchOutsideListener;

    public TouchOutsideDialog(Context context) {
        super(context);
    }

    public TouchOutsideDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected TouchOutsideDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable,cancelListener);
    }

    /**
     * 设置点击外部的监听事件
     * @param onTouchOutsideListener
     */
    public void setOnTouchOutside(OnTouchOutsideListener onTouchOutsideListener){
        this.onTouchOutsideListener = onTouchOutsideListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //触摸外部弹窗
        if (isOutOfBounds(getContext(), event)) {
            if (onTouchOutsideListener != null) {
                onTouchOutsideListener.onTouchOutside();
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 是否点击了弹窗外部
     * @param context 上下文
     * @param event  事件
     * @return true点击外部,false点击弹窗本身
     */
    private boolean isOutOfBounds(Context context, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        final View decorView = getWindow().getDecorView();
        return (x < -slop) || (y < -slop) || (x > (decorView.getWidth() + slop))
                || (y > (decorView.getHeight() + slop));
    }

    /**
     * 点击弹窗外部的接口
     */
    public interface OnTouchOutsideListener{
        void onTouchOutside();
    }

}