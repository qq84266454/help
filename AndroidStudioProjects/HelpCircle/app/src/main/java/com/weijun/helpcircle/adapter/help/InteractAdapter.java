package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.User;

import java.util.List;

public class InteractAdapter extends BaseQuickAdapter<User, BaseViewHolder> {
    public InteractAdapter(@Nullable List<User> data) {
        super(R.layout.item_interact, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        TextView mTvPosterName = helper.getView(R.id.mTvPosterName);
        mTvPosterName.setText(item.getName());
    }
}
