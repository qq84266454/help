package com.weijun.helpcircle.adapter.community;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.User;

import java.util.List;

public class ApplyCommunityAdapter extends BaseQuickAdapter<User, BaseViewHolder> {
    public ApplyCommunityAdapter(@Nullable List<User> data) {
        super(R.layout.item_apply_community,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {

    }
}
