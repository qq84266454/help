package com.weijun.helpcircle;

import android.os.Bundle;
import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.http.InterfaceParameters;

import butterknife.BindView;

public class TestActivity extends BaseActivity {

    @BindView(R.id.mIv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_test);
    }

    @Override
    protected void initView() {
        int screenWidth = ScreenUtils.getScreenWidth();
        int width = screenWidth / 4;
        String pre = InterfaceParameters.BASE_URL + "img/";
        RequestOptions options = new RequestOptions().centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .override(width, width);
        Glide.with(this).load(InterfaceParameters.BASE_URL_IMG + "_3_304ef35a961bba59b3d5e316c116fb98.png")
                .apply(options)
                .into(mIv);
    }
}
