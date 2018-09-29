package com.weijun.helpcircle.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.base.MyApp;
import com.weijun.helpcircle.http.ApiRequest;
import com.weijun.helpcircle.http.ApiService;
import com.weijun.helpcircle.http.InterfaceParameters;
import com.weijun.helpcircle.pojo.HelpCircleViewBean;
import com.weijun.helpcircle.pojo.ResponseBean;
import com.xw.repo.XEditText;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneLoginActivity extends BaseActivity {

    @BindView(R.id.mTvPhoneCountry)
    TextView mTvPhoneCountry;
    @BindView(R.id.mEtPhone)
    XEditText mEtPhone;
    @BindView(R.id.mTvNext)
    TextView mTvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_phone_login);
    }

    @Override
    protected void initView() {
        mTvPhoneCountry.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mTvPhoneCountry.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mEtPhone.setPadding(SizeUtils.dp2px(16) + mTvPhoneCountry.getWidth(), 0, 0, 0);
            }
        });

        mEtPhone.setSeparator(" ");
        mEtPhone.setPattern(new int[]{3, 4, 4});
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTvNext.setEnabled(RegexUtils.isMobileSimple(mEtPhone.getTrimmedString()));
            }
        });

    }

    @OnClick({R.id.mTvNext,R.id.mIvWXLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.mTvNext:
                doLogin();
                break;
            case R.id.mIvWXLogin:
                doWXLogin();
                break;
        }
    }

    private void doWXLogin() {
        // send oauth request
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        MyApp.getApplication().getWXApi().sendReq(req);
//        MyApp.getApplication().getWXApi().openWXApp();
    }

    private void doLogin() {
        ApiService apiService = ApiRequest.getInstance(InterfaceParameters.BASE_URL).create(ApiService.class);
//        Call<ResponseBody> call = apiService.doDoubanApi("25", "2");
        Call<ResponseBody> call = apiService.isPhoneRegister();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String string = response.body().string();
                        Log.e(TAG, string);
                        ResponseBean<List<HelpCircleViewBean>> responseBean = new Gson().fromJson(string, new TypeToken<ResponseBean<List<HelpCircleViewBean>>>() {
                        }.getType());
//                        ResponseBean responseBean = new Gson().fromJson(string, ResponseBean.class);
//                        Object resData = responseBean.getResData();
//                        String s = new Gson().toJson(resData);
                        Log.e(TAG, responseBean.toString());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Intent intent;
                    int i = new Random().nextInt(1);
                    intent = new Intent(PhoneLoginActivity.this, NewPhoneBinderActivity.class);
                    intent.putExtra("phone", mEtPhone.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }
}
