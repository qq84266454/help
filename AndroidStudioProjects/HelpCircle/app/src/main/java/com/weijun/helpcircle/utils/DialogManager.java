package com.weijun.helpcircle.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.view.dialog.TouchOutsideDialog;


/**
 * Created by zhengfei on 16/9/6.
 * Dialog工具类 一行弹窗
 * 简单使用
 * Dialog myDialog = DialogManager.newDialog(activity,R.layout.dialog_ask_isopen_notice)
 * .setCallBack(listener,R.id.tv_confir)
 * .show(true);
 * 如果需要获取子view的话 拆分成两部
 * 1.1DialogManager myDialogManager = DialogManager.newDialog(this,R.layout.dialog_ask_isopen_notice)
 * .setCallBack(this,R.id.tv_confir);
 * 1.2myDialogManager.show(true);
 * <p>
 * 2.View child = myDialogManager.getViewById(R.id.tv_confir);
 * 2.这里可以对child做想要的操作
 */
public class DialogManager {

    /**
     * 窗口view
     */
    private View contentView;
    /**
     * 窗口对象
     */
    private TouchOutsideDialog mDailog;
    /**
     * 键盘管理
     */
    private KeyboardService mKeyboardService;

    /**
     * 懒汉单例
     */
    private DialogManager() {
    }
    /**
     * 弹窗管理实例(私有化,单例模式)
     */
//    private static DialogManager instance = new DialogManager();
    /**
     * 弹窗序号，用于列表中弹窗使用
     */
    public static int position;

    /**
     * 创建弹窗管理类
     *
     * @param mActivity 窗口实例
     * @param layoutRes 布局资源
     * @return 弹窗管理类
     */
    public static DialogManager newDialog(Context mActivity, int layoutRes) {
        return new DialogManager(mActivity, layoutRes, R.style.dialogTheme);
    }


    public DialogManager(Context mActivity, int layoutRes) {
        this(mActivity, layoutRes, R.style.dialogTheme);
    }

    /**
     * 创建弹窗管理类
     *
     * @param mActivity 窗口实例
     * @param layoutRes 布局资源
     * @param theme     弹窗的主题
     * @return 弹窗管理类
     */
    public static DialogManager newDialog(Context mActivity, int layoutRes, int theme) {
        return new DialogManager(mActivity, layoutRes, theme);
    }

    private DialogManager(Context mActivity, int layoutRes, int theme) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(layoutRes, null);

        //创建弹窗实例
        mDailog = new TouchOutsideDialog(mActivity, theme);

        //设置布局
        mDailog.setContentView(contentView);

    }

    /**
     * 创建弹窗管理类
     *
     * @param position  弹窗序号
     * @param mActivity 窗口实例
     * @param layoutRes 布局资源
     * @return 弹窗管理类
     */
    public static DialogManager newDialog(int position, Activity mActivity, int layoutRes) {
        DialogManager.position = position;
        return new DialogManager(mActivity, layoutRes);
    }

    public DialogManager(int position, Activity mActivity, int layoutRes) {
        this(mActivity, layoutRes);
        DialogManager.position = position;
    }

    /**
     * 设置控件监听
     *
     * @param listener 监听回调
     * @param ids      需要设置点击事件的控件id
     * @return 弹窗管理类
     */
    public DialogManager setCallBack(View.OnClickListener listener, int... ids) {
        for (int id : ids) {
            View child = contentView.findViewById(id);
            child.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * 显示dialog
     *
     * @param cancelable 是否可取消
     */
    public DialogManager show(boolean cancelable) {
        //显示对话框
        mDailog.setCancelable(cancelable);
        mDailog.show();
        return this;
    }

    /**
     * 获取子view
     *
     * @param id 控件的id
     * @return 空间布局
     */
    public View getViewById(int id) {
        return contentView.findViewById(id);
    }

    public void dismiss() {
        if (mDailog != null && mDailog.isShowing())
            mDailog.dismiss();
    }

    /**
     * 关闭弹窗并隐藏软键盘
     *
     * @param activity 界面实例
     * @param view     界面中的View
     */
    public void dismissAndHideKeyboard(Activity activity, View view) {
        if (mDailog != null && mDailog.isShowing()) {
            if (activity != null) {
                if (mKeyboardService == null) {
                    mKeyboardService = new KeyboardService(activity);
                }
                mKeyboardService.hideKeyboard(view);
            }
            mDailog.dismiss();
        }
    }

    /**
     * 设置弹窗中TextView的内容
     *
     * @param res     TextView的资源id
     * @param content 设置的内容
     * @return 弹窗管理类
     */
    public DialogManager setText(int res, String content) {
        View viewById = getViewById(res);
        if (viewById instanceof TextView) {
            ((TextView) viewById).setText(content);
        }
        return this;
    }

    /**
     * 获取弹窗实例
     *
     * @return 弹窗实例
     */
    public TouchOutsideDialog getDailog() {
        return mDailog;
    }

    /**
     * 弹窗是否正在弹出
     *
     * @return
     */
    public boolean isShowing() {
        if (mDailog != null) {
            return mDailog.isShowing();
        }
        return false;
    }

    public void showAndAutoDismiss(boolean isCancelable, long time) {
        this.show(isCancelable);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, time);
    }


}