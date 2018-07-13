package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAddAdapter extends BaseQuickAdapter<User, BaseViewHolder> {
    public UserAddAdapter(int layoutResId, @Nullable List<User> data) {
        super(layoutResId, data);
    }

    public UserAddAdapter(@Nullable List<User> data) {
        super(R.layout.item_add_focus, data);
    }

    public UserAddAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        CircleImageView mIvImg = helper.getView(R.id.mIvImg);
        TextView mTvIntro = helper.getView(R.id.mTvIntro);
        TextView mTvName = helper.getView(R.id.mTvName);

        mTvIntro.setText(item.getIntro());
        mTvName.setText(item.getName());
    }
}
