package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.utils.glideutils.ShowImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyQRCodeActivity extends BaseActivity {

    @BindView(R.id.mViewStatusBar)
    View mViewStatusBar;
    @BindView(R.id.m_general_top)
    LinearLayout mGeneralTop;
    @BindView(R.id.mIvLeft)
    ImageView mIvLeft;
    @BindView(R.id.mTvLeft)
    TextView mTvLeft;
    @BindView(R.id.mLLLeft)
    LinearLayout mLLLeft;
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mIvRight)
    ImageView mIvRight;
    @BindView(R.id.mTvRight)
    TextView mTvRight;
    @BindView(R.id.mLLRight)
    LinearLayout mLLRight;
    @BindView(R.id.mLLUserMoreInfo)
    LinearLayout mLLUserMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        mIvRight.setVisibility(View.VISIBLE);
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_my_qrcode);
    }

    @OnClick({R.id.mLLLeft, R.id.mTvTitle, R.id.mLLRight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mTvTitle:
                mTvTitle.setText("助手二维码");
                break;
            case R.id.mLLRight:
                Glide.with(this).load(R.drawable.icon_more).into(mIvRight);
                break;
        }
    }
}
