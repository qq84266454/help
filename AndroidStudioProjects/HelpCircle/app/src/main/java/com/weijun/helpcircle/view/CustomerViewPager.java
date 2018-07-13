package com.weijun.helpcircle.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomerViewPager extends ViewPager {
    public CustomerViewPager(Context context) {
        super(context);
    }

    public CustomerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

  PointF mPointF =   new PointF();
    OnSingleTouchListener mOnSingleTouchListner;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 获取按下的坐标
                mPointF.x = ev.getX();
                mPointF.y = ev.getY();
                if (this.getChildCount()>1){
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
                case MotionEvent.ACTION_UP:
                    if (this.getChildCount()>1){
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (PointF.length(mPointF.x-ev.getX(),mPointF.y-ev.getY())<5.0){
                        // 单击事件
                        onSingleTouch(this);
                    }
                break;
            case MotionEvent.ACTION_MOVE:
                if (this.getChildCount()>1){
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void onSingleTouch(View view) {
        if (mOnSingleTouchListner !=null){
            mOnSingleTouchListner.onSingleTouch();
        }
    }

    public void setOnSingleTouchListner(OnSingleTouchListener listner){
        this.mOnSingleTouchListner = listner;
    }

    public interface OnSingleTouchListener {
         void onSingleTouch();
    }
}
