package com.weijun.helpcircle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommunityCreateActivity extends BaseActivity {

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
    @BindView(R.id.mTvAddress)
    TextView mTvAddress;
    @BindView(R.id.mTvNotice)
    TextView mTvNotice;
    @BindView(R.id.mTvCost)
    TextView mTvCost;
    @BindView(R.id.mTvCostValue)
    TextView mTvCostValue;
    @BindView(R.id.mTvCategory)
    TextView mTvCategory;
    @BindView(R.id.mTvCreate)
    TextView mTvCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_community_create);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("创建社区");
        mTvRight.setVisibility(View.GONE);

    }

    @OnClick({R.id.mLLLeft, R.id.mTvCreate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mTvCreate:
                startActivity(new Intent(this,CommunityInfoActivity.class));
                break;
        }
    }
}
