package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.Comment;

import java.util.List;

public class HelpDetailCommentAdapter extends BaseQuickAdapter<Comment, BaseViewHolder> {
    private Activity activity;

    public HelpDetailCommentAdapter(Activity activity, @Nullable List<Comment> data) {
        super(R.layout.item_help_detail_comment, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, Comment item) {
        TextView mTvName = helper.getView(R.id.mTvName);
        TextView mTvContent = helper.getView(R.id.mTvContent);

        mTvName.setText(item.getUser().getName());
        mTvContent.setText(item.getContent());
    }
}
