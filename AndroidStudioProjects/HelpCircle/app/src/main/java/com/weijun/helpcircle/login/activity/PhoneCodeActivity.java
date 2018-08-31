package com.weijun.helpcircle.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.utils.PhoneUtils;
import com.weijun.helpcircle.view.widget.VerificationCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneCodeActivity extends BaseActivity {
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mTvPhoneHint)
    TextView mTvPhoneHint;
    @BindView(R.id.mCodeView)
    VerificationCodeView mCodeView;
    private String phone;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_phone_code);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        phone = getIntent().getStringExtra("phone");
        mTvPhoneHint.setText(String.format("验证码已经发送到您的手机\n+86 %s", PhoneUtils.sort344(phone)));

        mCodeView.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {
            @Override
            public void onComplete(String content) {
                Intent intent = new Intent(PhoneCodeActivity.this, PwdSettingActivity.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
                finish();
            }
        });
    }

    @OnClick({R.id.mLLLeft, R.id.mTvReGet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mTvReGet:
                break;
        }
    }
}
