package com.weijun.helpcircle.ui;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.ui.fragment.MyTakePhotoFragment;

public class TakePhotoActivity extends BaseActivity {

    private MyTakePhotoFragment fragment;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_take_photo);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment1, fragment = new MyTakePhotoFragment(), "test");
        transaction.commit();
    }

    public void onClick(View v) {
        fragment.onClick(v);
    }
}
