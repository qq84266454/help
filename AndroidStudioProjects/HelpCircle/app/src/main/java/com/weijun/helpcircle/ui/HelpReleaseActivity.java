package com.weijun.helpcircle.ui;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.orhanobut.logger.Logger;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.HelpImgUploadAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.event.BusProvider;
import com.weijun.helpcircle.event.EventBusInfo;
import com.weijun.helpcircle.event.EventType;
import com.weijun.helpcircle.http.ApiRequest;
import com.weijun.helpcircle.http.ApiService;
import com.weijun.helpcircle.http.RequestCallback;
import com.weijun.helpcircle.pojo.ResponseBean;
import com.weijun.helpcircle.utils.DialogManager;
import com.weijun.helpcircle.view.popupwindow.BottomPopup;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.InvokeParam;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TImage;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.model.TakePhotoOptions;
import org.devio.takephoto.permission.InvokeListener;
import org.devio.takephoto.permission.PermissionManager;
import org.devio.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class HelpReleaseActivity extends BaseActivity implements TakePhoto.TakeResultListener, InvokeListener {
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
    @BindView(R.id.mEtContent)
    EditText mEtContent;
    @BindView(R.id.mRvHelpImg)
    RecyclerView mRvHelpImg;
    @BindView(R.id.mTvAddress)
    TextView mTvAddress;
    @BindView(R.id.mTvRewardRight)
    TextView mTvRewardRight;
    @BindView(R.id.mTvCountRight)
    TextView mTvCountRight;
    @BindView(R.id.mLLAddImg)
    LinearLayout mLLAddImg;
    @BindView(R.id.mIvLeft)
    ImageView mIvLeft;
    @BindView(R.id.mIvRight)
    ImageView mIvRight;
    @BindView(R.id.mLLAdress)
    LinearLayout mLLAdress;
    @BindView(R.id.mTvTotalCount)
    EditText mTvTotalCount;
    @BindView(R.id.mTvPartCount)
    EditText mTvPartCount;
    @BindView(R.id.mTvRelease)
    TextView mTvRelease;
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private ArrayList<TImage> images = new ArrayList<>();
    private HelpImgUploadAdapter mAdapter;
    private MultipartBody.Part[] parts;
    private String content;
    private String totalCount;
    private String partCount;
    private ApiService apiService = ApiRequest.getInstance().create(ApiService.class);
    private DialogManager dialogManager;
    private BottomPopup popup;
    ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
        takePhoto = getTakePhoto();
        takePhoto.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        takePhoto.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        takePhoto.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }


    @Override
    protected void setView() {
        setContentView(R.layout.activity_help_release);

    }

    protected void initView() {
        mLLRight.setVisibility(View.GONE);
        mTvLeft.setText("返回");
        mTvTitle.setText("发布任务");
        initImgRv();
    }

    private void initImgRv() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHelpImg.setLayoutManager(manager);
        mAdapter = new HelpImgUploadAdapter(this, images);
        mRvHelpImg.setAdapter(mAdapter);
    }

    @OnClick({R.id.mLLLeft, R.id.mLLRight, R.id.mLLAdress, R.id.mTvRelease, R.id.mLLAddImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLLLeft:
                finish();
                break;
            case R.id.mLLRight:
                break;
            case R.id.mLLAdress:
                startActivity(new Intent(this, AddressActivity.class));
                break;
            case R.id.mTvRelease:
                doRelease();
                break;
            case R.id.mLLAddImg:
                showImgDialog();
                break;
        }
    }

    private void doRelease() {
        if (dialogManager != null) {
            dialogManager = DialogManager.newDialog(this, R.layout.dialog_release_alert, R.style.dialogTheme);
            dialogManager.getViewById(R.id.mTvPositive).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogManager.dismiss();
                }
            });
        }
        content = mEtContent.getText().toString();
        totalCount = mTvTotalCount.getText().toString();
        partCount = mTvPartCount.getText().toString();

        if (TextUtils.isEmpty(content)) {
            dialogManager.setText(R.id.mTvHint, "请输入任务细节");
            dialogManager.show(true);
            return;
        }
        if (images.size() == 0) {
            dialogManager.setText(R.id.mTvHint, "请至少上传一张图片");
            dialogManager.show(true);
            return;
        }
        if (TextUtils.isEmpty(totalCount)) {
            dialogManager.setText(R.id.mTvHint, "请输入总投入");
            dialogManager.show(true);
            return;
        }
        if (TextUtils.isEmpty(partCount)) {
            dialogManager.setText(R.id.mTvHint, "请输入最大转发人数");
            dialogManager.show(true);
            return;
        }
        if (Double.parseDouble(totalCount) / Integer.parseInt(partCount) < 10) {
            dialogManager.setText(R.id.mTvHint, "人均不能低于10个互助币");
            dialogManager.show(true);
            return;
        }

        if (images.size() > 0) {
            parts = new MultipartBody.Part[images.size()];
            Map<String, String> params = new HashMap<>();
            params.put("operate", "fileUpload");
            params.put("version", "1.1");
            params.put("user_id", "3");
            params.put("fileNumber", images.size() + "");
            for (int i = 0; i < images.size(); i++) {
                File file = new File(images.get(i).getOriginalPath());
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                parts[i] = MultipartBody.Part.createFormData("myfile[]", file.getName(), requestFile);
            }

            Call<ResponseBean<String>> call = apiService.doFileUpload(params, parts);
            showProgressDialog();
            call.enqueue(new RequestCallback<ResponseBean<String>>() {
                @Override
                public void onFinish() {
                    dismissProgressDialog();
                }

                @Override
                public void onFailure(int code, String msg) {

                }

                @Override
                public void onSuccess(Response<ResponseBean<String>> response) {
                    if (response.body().getResCode().equals("000")) {
                        String resData = response.body().getResData();
                        doHelpCircleMsgAdd(resData);
                    }
                }
            });
        }
    }

    private void doHelpCircleMsgAdd(String img) {
//        operate=helpCircleAdd&version=1.2&content=发布互助圈&coin_total=200.99&publisher=70&parti_chances=21&hc_type=3
        Map<String, String> params = new HashMap<>();
        params.put("operate", "helpCircleAdd");
        params.put("version", "1.2");
        params.put("content", content);
        params.put("coin_total", totalCount);
        params.put("publisher", "3");
        params.put("parti_chances", partCount);
        params.put("hc_type", "1");
        params.put("img_url", img);
        Call<ResponseBean> call = apiService.doHelpCircleMsgAdd(params);
        showProgressDialog();
        call.enqueue(new RequestCallback<ResponseBean>() {
            @Override
            public void onFinish() {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(int code, String msg) {
                Logger.e(msg + ":" + code);
            }

            @Override
            public void onSuccess(Response<ResponseBean> response) {
                if ("000".equals(response.body().getResCode())) {
                    ToastUtils.showShort("发布成功");
                    finish();
                    BusProvider.getInstance().post(new EventBusInfo<>(EventType.RELEASE_HELP_CIRCLE_SUCCESS));
                }
            }
        });
    }

    private void showImgDialog() {
        if (popup == null) {
            popup = new BottomPopup(this, new BottomPopup.OnItemClickListener() {
                @Override
                public void onItemOneClick() {
                    addImg(1);
                }

                @Override
                public void onItemTwoClick() {
                    addImg(0);
                }

                @Override
                public void onItemCancelClick(BottomPopup popup) {
                    popup.dismiss();
                }
            });
            popup.setText(R.id.mTvOne, "拍照");
            popup.setText(R.id.mTvTwo, "从手机相册选择");
            popup.setText(R.id.mTvCancel, "取消");
        }
        popup.show(getWindow().getDecorView());
    }

    private void addImg(int type) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        if (type == 0) {

            takePhoto.onPickMultiple(3 - images.size());
        } else {
            takePhoto.onPickFromCapture(imageUri);
        }
    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(true);
        takePhoto.setTakePhotoOptions(builder.create());

    }

    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    private void configCompress(TakePhoto takePhoto) {
        takePhoto.onEnableCompress(null, false);
        int maxSize = 102400;
        CompressConfig config;
        config = new CompressConfig.Builder().setMaxSize(maxSize)
                .setMaxPixel(200)
                .enableReserveRaw(true)
                .create();
        takePhoto.onEnableCompress(config, false);
    }

    @Override
    public void takeSuccess(TResult result) {
        mAdapter.addData(result.getImages());
        if (images.size() >= 3) {
            mLLAddImg.setVisibility(View.GONE);
        }
    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    @Override
    public void onEventMain(EventBusInfo info) {
        super.onEventMain(info);
    }
}
