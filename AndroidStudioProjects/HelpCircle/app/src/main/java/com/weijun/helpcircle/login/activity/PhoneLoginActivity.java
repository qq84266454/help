package com.weijun.helpcircle.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.http.ApiRequest;
import com.weijun.helpcircle.http.ApiService;
import com.xw.repo.XEditText;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class PhoneLoginActivity extends BaseActivity {

    @BindView(R.id.mTvPhoneCountry)
    TextView mTvPhoneCountry;
    @BindView(R.id.mEtPhone)
    XEditText mEtPhone;
    @BindView(R.id.mTvNext)
    TextView mTvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_phone_login);
    }

    @Override
    protected void initView() {
        mTvPhoneCountry.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mTvPhoneCountry.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mEtPhone.setPadding(SizeUtils.dp2px(16) + mTvPhoneCountry.getWidth(), 0, 0, 0);
            }
        });

        mEtPhone.setSeparator(" ");
        mEtPhone.setPattern(new int[]{3, 4, 4});
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTvNext.setEnabled(RegexUtils.isMobileSimple(mEtPhone.getTrimmedString()));
            }
        });

    }

    @OnClick({R.id.mTvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.mTvNext:
                doLogin();
                break;
        }
    }

    private void doLogin() {
        Intent intent = null;
        int i = new Random().nextInt(1);
        intent = new Intent(this, NewPhoneBinderActivity.class);
        intent.putExtra("phone", mEtPhone.getText().toString());
        startActivity(intent);
    }
}
