package com.weijun.helpcircle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.utils.DialogManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelpReleaseActivity extends BaseActivity {
    @BindView(R.id.mTvLeft)
    TextView mTvLeft;
    @BindView(R.id.mLLLeft)
    LinearLayout mLLLeft;
    @BindView(R.id.mTvRight)
    TextView mTvRight;
    @BindView(R.id.mLLRight)
    LinearLayout mLLRight;
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mEtContent)
    EditText mEtContent;
    @BindView(R.id.mRvAddImg)
    RecyclerView mRvAddImg;
    @BindView(R.id.mRvHelpImg)
    RecyclerView mRvHelpImg;
    @BindView(R.id.mTvAddress)
    TextView mTvAddress;
    @BindView(R.id.mTvRewardRight)
    TextView mTvRewardRight;
    @BindView(R.id.mTvCountRight)
    TextView mTvCountRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_release);
        ButterKnife.bind(this);
        initView();
    }

    protected void initView() {
        mLLRight.setVisibility(View.GONE);
        mTvLeft.setText("返回");
        mTvTitle.setText("发布互助圈");
    }

    @OnClick({R.id.mLLLeft, R.id.mLLRight, R.id.mLLAdress, R.id.mTvRelease})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mLLRight:
                break;
            case R.id.mLLAdress:
                startActivity(new Intent(this, AddressActivity.class));
                break;
            case R.id.mTvRelease:
                DialogManager dialogManager = DialogManager.newDialog(this, R.layout.dialog_release_alert, R.style.dialogTheme);
                dialogManager.show(true);
                break;
        }
    }
}
