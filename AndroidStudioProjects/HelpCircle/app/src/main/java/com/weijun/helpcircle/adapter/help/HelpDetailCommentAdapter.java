package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.HelpCircleMsgBean;
import com.weijun.helpcircle.pojo.test.Comment;
import com.weijun.helpcircle.ui.HelpDetailActivity;

import java.util.List;

public class HelpDetailCommentAdapter extends BaseQuickAdapter<HelpCircleMsgBean, BaseViewHolder> {
    private Activity activity;

    public HelpDetailCommentAdapter(Activity activity, @Nullable List<HelpCircleMsgBean> data) {
        super(R.layout.item_help_detail_comment, data);
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, HelpCircleMsgBean item) {
        TextView mTvName = helper.getView(R.id.mTvName);
        TextView mTvContent = helper.getView(R.id.mTvContent);

        mTvName.setText(item.getReply_nick_name());
        mTvContent.setText(item.getReply_content());
    }
}
