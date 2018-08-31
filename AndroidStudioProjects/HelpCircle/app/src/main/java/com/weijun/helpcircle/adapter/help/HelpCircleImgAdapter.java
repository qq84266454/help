package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.http.InterfaceParameters;
import com.weijun.helpcircle.pojo.HelpCircleMsgBean;
import com.weijun.helpcircle.pojo.HelpCircleViewBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HelpCircleImgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Activity activity;

    public HelpCircleImgAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public HelpCircleImgAdapter(@Nullable List<String> data) {
        super(data);
    }

    public HelpCircleImgAdapter(int layoutResId) {
        super(layoutResId);
    }

    public HelpCircleImgAdapter(Activity activity, @Nullable List<String> data) {
        this(R.layout.item_img, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int screenWidth = ScreenUtils.getScreenWidth();
        int width = screenWidth / 4;
        Logger.e(width+"");
        String pre = InterfaceParameters.BASE_URL + "img/";
        Glide.with(activity)
                .load(pre + item)
                .asBitmap()
                .override(width, width)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.mIv));
    }


}
