package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity {

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
    @BindView(R.id.mTvAddress)
    TextView mTvAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initView() {
        mTvTitle.setText("所在地");
        mTvRight.setVisibility(View.GONE);
        mTvLeft.setVisibility(View.GONE);
    }

    @OnClick({R.id.mTvLeft, R.id.mLLLeft, R.id.mLLRight, R.id.mTvTitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvLeft:
                break;
            case R.id.mLLLeft:
                break;
            case R.id.mLLRight:
                break;
            case R.id.mTvTitle:
                break;
        }
    }
}
