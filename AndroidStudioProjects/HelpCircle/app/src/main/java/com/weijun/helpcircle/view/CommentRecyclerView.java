package com.weijun.helpcircle.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class CommentRecyclerView extends RecyclerView {

    private OnCommentClickListener listener;

    public void clickComment(View view,int position) {
        if (listener != null) {
            listener.onItemClick(view,position);
        }
    }

    public void setOnCommentClickListener(OnCommentClickListener listener) {
        this.listener = listener;
    }

    public CommentRecyclerView(Context context) {
        super(context);
    }

    public CommentRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public interface OnCommentClickListener {
        void onItemClick(View view,int position);
    }
}
