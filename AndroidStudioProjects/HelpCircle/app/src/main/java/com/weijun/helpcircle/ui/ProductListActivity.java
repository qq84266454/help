package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.ProductListAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.http.RequestCallback;
import com.weijun.helpcircle.pojo.ProductListResponseBean;
import com.weijun.helpcircle.pojo.ResponseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Response;

public class ProductListActivity extends BaseActivity {
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mRvFriend)
    RecyclerView mRvFriend;

    ProductListAdapter mAdapter;
    private List<ProductListResponseBean> data = new ArrayList<>();

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
        mTvTitle.setText("企业服务");
        initRv();
        getProductList();
    }

    private void getProductList() {
        Map<String, String> map = new HashMap<>();
        // operate=productListGet&version=1.1&user_id=73&recordCount=20
        map.put("operate", "productListGet");
        map.put("version", "1.1");
        map.put("user_id", "73");
        map.put("recordCount", "20");
        Call<ResponseBean<List<ProductListResponseBean>>> call = mApiService.doProductListGet(map);
        call.enqueue(new RequestCallback<ResponseBean<List<ProductListResponseBean>>>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onFailure(int code, String msg) {

            }

            @Override
            public void onSuccess(Response<ResponseBean<List<ProductListResponseBean>>> response) {
                if (response.body().getResCode().equals("000")) {
                    dealData(response.body().getResData());
                } else {
                    ToastUtils.showShort(response.body().getResMsg() != null ? response.body().getResMsg() : "");
                }
            }
        });
    }

    private void dealData(List<ProductListResponseBean> resData) {
        mAdapter.setNewData(resData);
    }

    private void initRv() {
        mRvFriend.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ProductListAdapter(data);
        mRvFriend.setAdapter(mAdapter);
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
