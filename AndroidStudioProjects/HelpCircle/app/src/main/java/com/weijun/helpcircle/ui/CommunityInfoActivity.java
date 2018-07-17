package com.weijun.helpcircle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommunityInfoActivity extends BaseActivity {

    @BindView(R.id.mIvLeft)
    ImageView mIvLeft;
    @BindView(R.id.mTvLeft)
    TextView mTvLeft;
    @BindView(R.id.mLLLeft)
    LinearLayout mLLLeft;
    @BindView(R.id.mIvRight)
    ImageView mIvRight;
    @BindView(R.id.mTvRight)
    TextView mTvRight;
    @BindView(R.id.mLLRight)
    LinearLayout mLLRight;
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mTvName)
    TextView mTvName;
    @BindView(R.id.mIvRight1)
    ImageView mIvRight1;
    @BindView(R.id.mTvNotice)
    TextView mTvNotice;
    @BindView(R.id.mIvRight2)
    ImageView mIvRight2;
    @BindView(R.id.mTvLabel)
    TextView mTvLabel;
    @BindView(R.id.mIvRight3)
    ImageView mIvRight3;
    @BindView(R.id.mTvAccess)
    TextView mTvAccess;
    @BindView(R.id.mIvRight4)
    ImageView mIvRight4;
    @BindView(R.id.mTvQRCode)
    TextView mTvQRCode;
    @BindView(R.id.mIvRight5)
    ImageView mIvRight5;
    @BindView(R.id.mTvQuit)
    TextView mTvQuit;
    @BindView(R.id.mTvExit)
    TextView mTvExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_community_info);

    }

    @Override
    protected void initView() {
        mTvTitle.setText("社区信息");

    }

    @OnClick({R.id.mLLLeft, R.id.mLLRight, R.id.mTvExit,R.id.mFlInvite,R.id.mFLRemove})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mLLRight:
                break;
            case R.id.mTvExit:
                break;
            case R.id.mFlInvite:
                startActivity(new Intent(this,CommunityInviteActivity.class));
                break;
            case R.id.mFLRemove:
                startActivity(new Intent(this,CommunityRemoveActivity.class));
                break;
        }
    }
}
