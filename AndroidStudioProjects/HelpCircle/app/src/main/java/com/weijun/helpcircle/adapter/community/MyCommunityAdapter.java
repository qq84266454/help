package com.weijun.helpcircle.adapter.community;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.Community;

import java.util.List;

public class MyCommunityAdapter extends BaseQuickAdapter<Community,BaseViewHolder>{
    public MyCommunityAdapter(@Nullable List<Community> data) {
        super(R.layout.item_my_community,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Community item) {

    }
}
