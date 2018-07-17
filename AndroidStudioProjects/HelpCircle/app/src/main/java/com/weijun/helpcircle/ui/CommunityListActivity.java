package com.weijun.helpcircle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.community.MyCommunityAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.pojo.Community;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommunityListActivity extends BaseActivity {

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
    @BindView(R.id.mRvCommuity)
    RecyclerView mRvCommuity;
    private MyCommunityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_community_list);

    }

    @Override
    protected void initView() {
        mTvTitle.setText("我的社区");
        mTvRight.setText("创建社区");
        mTvRight.setVisibility(View.VISIBLE);
        mTvLeft.setText("返回");
        mAdapter = new MyCommunityAdapter(testData());
        mRvCommuity.setAdapter(mAdapter);
        mRvCommuity.setLayoutManager(new LinearLayoutManager(this));
        mRvCommuity.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private List<Community> testData() {
        List<Community> communities = new ArrayList<>();
        communities.add(new Community("论坛1"));
        communities.add(new Community("论坛2"));
        communities.add(new Community("论坛3"));
        communities.add(new Community("论坛4"));
        return communities;
    }

    @OnClick({R.id.mLLLeft, R.id.mLLRight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mLLRight:
                startActivity(new Intent(this, CommunityCreateActivity.class));
                break;
        }
    }
}
