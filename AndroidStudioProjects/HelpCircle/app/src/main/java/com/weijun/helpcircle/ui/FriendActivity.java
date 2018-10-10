package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.FriendAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.http.RequestCallback;
import com.weijun.helpcircle.pojo.FriendGetBean;
import com.weijun.helpcircle.pojo.ResponseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class FriendActivity extends BaseActivity {
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mRvFriend)
    RecyclerView mRvFriend;

    List<FriendGetBean> friends = new ArrayList<>();
    private FriendAdapter mAdapter;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_friend);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        mTvTitle.setText("我的好友");
        mRvFriend.setLayoutManager(new LinearLayoutManager(this));
        if (mAdapter == null)
            mAdapter = new FriendAdapter(friends);
        mRvFriend.setAdapter(mAdapter);
        getFriends();
    }

    private void getFriends() {
        Map<String, String> map = new HashMap<>();
        //operate=friendListGet&version=1.1&user_id=2&create_time=2018-07-03 10:07:01
        map.put("operate", "friendListGet");
        map.put("version", "1.1");
        map.put("user_id", "3");
//        map.put("create_time","");
        Call<ResponseBean<List<FriendGetBean>>> call = mApiService.doFriendListGet(map);
        call.enqueue(new RequestCallback<ResponseBean<List<FriendGetBean>>>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(Response<ResponseBean<List<FriendGetBean>>> response) {
                if ("000".equals(response.body().getResCode())) {
                    dealSuccessData(response.body().getResData());
                }
            }
        });
    }

    private void dealSuccessData(List<FriendGetBean> friends) {
        mAdapter.setNewData(friends);
    }

    @OnClick({R.id.mLLLeft, R.id.mLLRight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mLLRight:
                break;
        }
    }
}
