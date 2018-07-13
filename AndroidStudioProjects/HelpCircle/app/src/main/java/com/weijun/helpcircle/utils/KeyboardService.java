package com.weijun.helpcircle.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardService {
    private final Activity mActivity;

    public KeyboardService(Activity activity) {
        this.mActivity = activity;
    }

    public void hideKeyboardDelayed(final View view) {
        if(mActivity==null)return;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideKeyboard(view);
            }
        }, 200);
    }

    public void showKeyboardDelayed(final View view) {
        if(mActivity==null)return;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                showKeyboard(view);
            }
        }, 200);
    }

    public void hideKeyboard(final View view) {
        if(mActivity==null)return;
//        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN );
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void showKeyboard(final View view) {
        if(mActivity==null)return;
        view.requestFocus();
//        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

    public void focusAndShowKeyboard(final View view) {
        if(mActivity==null)return;
        view.setFocusable(true);
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

    public void clearFocusAndHideKeyboard(final View view) {
        if(mActivity==null)return;
        view.setFocusable(false);
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}