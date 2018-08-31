package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.HelpCircleMsgBean;
import com.weijun.helpcircle.pojo.test.Comment;
import com.weijun.helpcircle.view.Clickable;

import java.util.List;

public class HelpCommentAdapter extends BaseQuickAdapter<HelpCircleMsgBean, BaseViewHolder> {
    public HelpCommentAdapter(int layoutResId, @Nullable List<HelpCircleMsgBean> data) {
        super(layoutResId, data);
    }

    public HelpCommentAdapter(@Nullable List<HelpCircleMsgBean> data) {
        this(R.layout.item_help_comment, data);
    }

    public HelpCommentAdapter(int layoutResId) {
        super(layoutResId);
    }

    public HelpCommentAdapter() {
        super(R.layout.item_help_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HelpCircleMsgBean msgBean) {
        final String reply_nick_name = msgBean.getReply_nick_name();
        SpannableString ss;
        if (msgBean.getRecieve_id() != null) {
            final String recieve_nick_name = msgBean.getRecieve_nick_name();
            ss = new SpannableString(String.format("%s 回复 %s", reply_nick_name,
                    recieve_nick_name));
            ss.setSpan(new Clickable(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShort(reply_nick_name);
                }
            }), 0, reply_nick_name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(new Clickable(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showShort(recieve_nick_name);
                }
            }), reply_nick_name.length() + 3, recieve_nick_name.length() + reply_nick_name.length() + 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            ss = new SpannableString(reply_nick_name);
            ss.setSpan(new Clickable(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(mContext, msgBean.getReply_nick_name(), Toast.LENGTH_SHORT).show();
                    ToastUtils.showShort(msgBean.getReply_nick_name());
                }
            }), 0, reply_nick_name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        TextView mCommentNameTv = helper.getView(R.id.mCommentNameTv);
        TextView mCommentContentTv = helper.getView(R.id.mCommentContentTv);
        mCommentContentTv.setText(msgBean.getReply_content());
        mCommentNameTv.setText(ss);
        mCommentNameTv.setMovementMethod(LinkMovementMethod.getInstance());
        mCommentContentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, msgBean.getReply_content(), Toast.LENGTH_SHORT).show();
                ToastUtils.showShort(msgBean.getReply_content());
            }
        });
    }
}
