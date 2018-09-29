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
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;
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

    public HelpCircleImgAdapter(Activity activity, @Nullable List<String> data) {
        this(R.layout.item_img, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        int screenWidth = ScreenUtils.getScreenWidth();
        int width = screenWidth / 4;
        String pre = InterfaceParameters.BASE_URL + "img/";
        RequestOptions options = new RequestOptions().centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .override(width, width);
        Logger.e(pre + item);
        Picasso.get()
                .load(pre + item)
                .resize(width,width)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.mIv));
    }


}
