package com.huatec.helpcircledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huatec.helpcircledemo.service.MusicPlayerManager;

/**
 * Created by wm on 2016/2/25.
 * activity基类
 */
public class BaseActivity extends AppCompatActivity {

    private String TAG = "BaseActivity";

    /**
     * @param outState 取消保存状态
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * @param savedInstanceState 取消保存状态
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //服务的初始化
        MusicPlayerManager.startServiceIfNecessary(getApplicationContext());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService();
    }

    public void unbindService() {
    }

}
