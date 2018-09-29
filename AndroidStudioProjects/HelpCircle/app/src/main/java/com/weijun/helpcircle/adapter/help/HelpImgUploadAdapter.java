package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;

import org.devio.takephoto.model.TImage;

import java.util.List;

public class HelpImgUploadAdapter extends BaseQuickAdapter<TImage,BaseViewHolder> {


    private  Activity activity;

    public HelpImgUploadAdapter(@NonNull Activity activity, @Nullable List<TImage> data) {
        super(R.layout.item_help_img_upload,data);
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, TImage item) {
        ImageView imageView = helper.getView(R.id.mIv);
        RequestOptions options = new RequestOptions()
                .centerCrop();
        Glide.with(activity)
                .load(item.getCompressPath())
                .apply(options)
                .into(imageView);
    }
}
