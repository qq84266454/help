package com.weijun.helpcircle.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.ui.MainActivity;
import com.weijun.helpcircle.utils.PhoneUtils;
import com.weijun.helpcircle.view.dialog.HelpToastDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class PwdSettingActivity extends BaseActivity {
    @BindView(R.id.mTvNext)
    TextView mTvNext;
    @BindView(R.id.mTvPhoneHint)
    TextView mTvPhoneHint;
    @BindView(R.id.mEtPwd)
    EditText mEtPwd;
    @BindView(R.id.mTvPwdRegex)
    TextView mTvPwdRegex;
    private String phone;
    private HelpToastDialog dialog;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_pwd_setting);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        phone = getIntent().getStringExtra("phone");
        mEtPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTvNext.setEnabled(s.length() > 0);
            }
        });

        mTvPhoneHint.setText(String.format("您可以使用设置的密码登录您的%s的账号", PhoneUtils.formatPass(phone)));
    }

    @OnClick({R.id.mLLLeft, R.id.mTvNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mTvNext:
                doNext();
                break;
        }
    }

    private void doNext() {
        boolean match = RegexUtils.isMatch("^(?=.*[a-zA-Z0-9].*)(?=.*[a-zA-Z\\\\W].*)(?=.*[0-9\\\\W].*).{8,16}$", mEtPwd.getText().toString());
        if (!match) {
            if (dialog == null) {
                dialog = new HelpToastDialog(this, R.layout.general_error_toast);
                dialog.setText(R.id.mTvMsg, "设置密码格式不正确");
                dialog.setImage(R.id.mIvMsg, R.drawable.error_reminder);
            }
            dialog.showAndAutoDismiss();
        } else {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

    }
}
