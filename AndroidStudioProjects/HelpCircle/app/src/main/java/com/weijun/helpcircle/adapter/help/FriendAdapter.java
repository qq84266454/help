package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.FriendGetBean;
import com.weijun.helpcircle.pojo.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendAdapter extends BaseQuickAdapter<FriendGetBean, BaseViewHolder> {
    public FriendAdapter(@Nullable List<FriendGetBean> data) {
        super(R.layout.item_friend, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FriendGetBean item) {
        CircleImageView mIvUser = helper.getView(R.id.mIvUser);

        TextView mTvUsername = helper.getView(R.id.mTvUsername);
        mTvUsername.setText(item.getNick_name());
        helper.getView(R.id.mIvUser);
    }
}
