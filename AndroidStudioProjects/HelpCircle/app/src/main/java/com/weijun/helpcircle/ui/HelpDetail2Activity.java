package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.HelpCircleImgAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.pojo.HelpCircleViewBean;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HelpDetail2Activity extends BaseActivity {

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
    @BindView(R.id.mTvHelpContent)
    TextView mTvHelpContent;
    @BindView(R.id.mHelpImgRv)
    RecyclerView mHelpImgRv;
    @BindView(R.id.mTvHasRead)
    TextView mTvHasRead;
    @BindView(R.id.mTvAllCanTime)
    TextView mTvAllCanTime;
    private HelpCircleViewBean helpCircleViewBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_help_detail2);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("互助详情");
        mLLRight.setVisibility(View.GONE);
        helpCircleViewBean = getIntent().getParcelableExtra("helpCircleViewBean");
        mTvHelpContent.setText(helpCircleViewBean.getHelpCircleContent());
        String img_url = helpCircleViewBean.getImg_url();
        String[] split = img_url.split(";");
        List<String> imgs = Arrays.asList(split);
        HelpCircleImgAdapter helpCircleImgAdapter = new HelpCircleImgAdapter(this, imgs);
        helpCircleImgAdapter.setType(1);
        mHelpImgRv.setAdapter(helpCircleImgAdapter);
        mHelpImgRv.setLayoutManager(new LinearLayoutManager(this));
        mTvHasRead.setText("阅读" + helpCircleViewBean.getView_times());
        mTvAllCanTime.setText(helpCircleViewBean.getAll_can_see_time());
    }

    @OnClick({R.id.mLLLeft, R.id.mTvShare, R.id.mTvBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mTvShare:
                break;
            case R.id.mTvBack:
                finish();
                break;
        }
    }
}
