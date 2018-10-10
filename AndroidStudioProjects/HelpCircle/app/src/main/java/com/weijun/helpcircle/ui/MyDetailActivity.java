package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.TradeDetailAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.http.RequestCallback;
import com.weijun.helpcircle.pojo.ResponseBean;
import com.weijun.helpcircle.pojo.TradeDetailResponseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

public class MyDetailActivity extends BaseActivity {
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mRvFriend)
    RecyclerView mRvFriend;
    private List<TradeDetailResponseBean> data = new ArrayList<>();
    private TradeDetailAdapter mAdapter;

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
        mTvTitle.setText("我的明细");
        initRv();
        tradeDetailQuery();
    }

    private void initRv() {
        mAdapter = new TradeDetailAdapter(data);
        mRvFriend.setAdapter(mAdapter);
        mRvFriend.setLayoutManager(new LinearLayoutManager(this));
    }

    private void tradeDetailQuery() {
        Map<String, String> map = new HashMap<>();
        //http://118.178.193.11/hzq/webservices.php?operate=tradeDetailQuery&version=1.1
        // &user_id=1&recordCount=99&ctimeFrom=2018-01-01&ctimeTo=2018-09-01
        map.put("operate", "tradeDetailQuery");
        map.put("version", "1.1");
        map.put("user_id", "1");
        map.put("recordCount", "99");
        map.put("ctimeFrom", "2018-01-01");
        map.put("ctimeTo", "2018-09-01");
        Call<ResponseBean<List<TradeDetailResponseBean>>> call = mApiService.doTradeDetailQuery(map);
        call.enqueue(new RequestCallback<ResponseBean<List<TradeDetailResponseBean>>>() {
            @Override
            public void onFinish() {
            }

            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(Response<ResponseBean<List<TradeDetailResponseBean>>> response) {
                if (response.body().getResCode().equals("000")) {
                    dealData(response.body().getResData());
                }
            }
        });
    }

    private void dealData(List<TradeDetailResponseBean> resData) {
        mAdapter.setNewData(resData);
    }

    @OnClick({R.id.mLLLeft})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;

        }
    }
}
