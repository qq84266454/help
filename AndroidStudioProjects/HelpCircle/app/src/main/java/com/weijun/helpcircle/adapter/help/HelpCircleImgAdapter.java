package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.http.InterfaceParameters;
import com.weijun.helpcircle.pojo.HelpCircleMsgBean;
import com.weijun.helpcircle.pojo.HelpCircleViewBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HelpCircleImgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Activity activity;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type = 0;

    public HelpCircleImgAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public HelpCircleImgAdapter(Activity activity, @Nullable List<String> data) {
        this(R.layout.item_img, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int screenWidth = ScreenUtils.getScreenWidth();
        int width = screenWidth / 4;
        String pre = InterfaceParameters.BASE_URL + "img/";
        Logger.e(pre + item);
        if (type == 0)
            Picasso.get()
                    .load(pre + item)
                    .resize(width, width)
                    .centerCrop()
                    .into((ImageView) helper.getView(R.id.mIv));
        else {
            loadImg(helper, item, pre);
        }
    }

    private void loadImg(BaseViewHolder helper, String item, String pre) {
        Transformation transformation = new Transformation() {

            @Override
            public Bitmap transform(Bitmap source) {

                int targetWidth = ScreenUtils.getScreenWidth();

                if (source.getWidth() == 0) {
                    return source;
                }

                //如果图片小于设置的宽度，则返回原图
                if (source.getWidth() < targetWidth) {
                    return source;
                } else {
                    //如果图片大小大于等于设置的宽度，则按照设置的宽度比例来缩放
                    double aspectRatio = (double) source.getHeight() / (double) source.getWidth();
                    int targetHeight = (int) (targetWidth * aspectRatio);
                    if (targetHeight != 0 && targetWidth != 0) {
                        Bitmap result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false);
                        if (result != source) {
                            // Same bitmap is returned if sizes are the same
                            source.recycle();
                        }
                        return result;
                    } else {
                        return source;
                    }
                }

            }

            @Override
            public String key() {
                return "transformation" + " desiredWidth";
            }
        };
        Picasso.get()
                .load(pre + item)
                .transform(transformation)
                .into((ImageView) helper.getView(R.id.mIv));
    }


}
