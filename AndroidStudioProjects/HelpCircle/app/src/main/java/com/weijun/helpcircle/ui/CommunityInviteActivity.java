package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.community.InviteCommunityAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.pojo.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommunityInviteActivity extends BaseActivity {

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
    @BindView(R.id.mRvCommuity)
    RecyclerView mRvCommuity;

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
        mTvTitle.setText("邀请加入社区");
        InviteCommunityAdapter mAdapter = new InviteCommunityAdapter(testData());
        View view = LayoutInflater.from(this).inflate(R.layout.invite_community_header, null, false);
        mAdapter.setHeaderView(view);
        mRvCommuity.setLayoutManager(new LinearLayoutManager(this));
        mRvCommuity.setAdapter(mAdapter);
    }

    private List<User> testData() {
        List<User> list = new ArrayList<>();
        list.add(new User("张三1"));
        list.add(new User("张三2"));
        list.add(new User("张三3"));
        return list;
    }

    @OnClick(R.id.mLLLeft)
    public void onViewClicked() {
        finish();
    }
}
