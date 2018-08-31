package com.weijun.helpcircle.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.view.widget.VerificationCodeView;

import butterknife.BindView;
import butterknife.OnClick;

public class NewPhoneBinderActivity extends BaseActivity {
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mIvCode)
    ImageView mIvCode;
    @BindView(R.id.mTvRefreshCode)
    TextView mTvRefreshCode;
    @BindView(R.id.mCodeView)
    VerificationCodeView mCodeView;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_new_phone_binder);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        mTvTitle.setVisibility(View.GONE);

        mCodeView.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {
            @Override
            public void onComplete(String content) {
                doNext();
            }
        });
    }

    private void doNext() {
        Intent intent = new Intent(this, PhoneCodeActivity.class);
        intent.putExtra("phone", getIntent().getStringExtra("phone"));
        startActivity(intent);
        finish();
    }

    @OnClick({R.id.mLLLeft, R.id.mTvRefreshCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mTvRefreshCode:
                break;
        }
    }
}
