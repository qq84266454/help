package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.Comment;
import com.weijun.helpcircle.view.Clickable;

import java.util.List;

public class HelpCommentAdapter extends BaseQuickAdapter<Comment, BaseViewHolder> {
    public HelpCommentAdapter(int layoutResId, @Nullable List<Comment> data) {
        super(layoutResId, data);
    }

    public HelpCommentAdapter(@Nullable List<Comment> data) {
        this(R.layout.item_help_comment, data);
    }

    public HelpCommentAdapter(int layoutResId) {
        super(layoutResId);
    }

    public HelpCommentAdapter() {
        super(R.layout.item_help_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, final Comment comment) {
        String username = comment.getUser().getName();
        SpannableString ss = new SpannableString(username + ": " + comment.getContent());
        ss.setSpan(new Clickable(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, comment.getUser().toString(), Toast.LENGTH_SHORT).show();
            }
        }), 0, username.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView mCommentNameTv = helper.getView(R.id.mCommentNameTv);
        mCommentNameTv.setText(ss);
        mCommentNameTv.setMovementMethod(LinkMovementMethod.getInstance());
        mCommentNameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, comment.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
