package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.HelpCircleMsgBean;
import com.weijun.helpcircle.pojo.HelpCircleViewBean;
import com.weijun.helpcircle.ui.MainActivity;
import com.weijun.helpcircle.utils.DateUtils;
import com.weijun.helpcircle.utils.TimeCalc;
import com.weijun.helpcircle.view.CommentRecyclerView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HelpCircleAdapter extends BaseQuickAdapter<HelpCircleViewBean, BaseViewHolder> {
    private RecyclerView recyclerView;
    private Activity activity;
    private boolean isOpen;

    public HelpCircleAdapter(int layoutResId, @Nullable List<HelpCircleViewBean> data) {
        super(layoutResId, data);
    }

    public HelpCircleAdapter(@Nullable List<HelpCircleViewBean> data) {
        super(data);
    }

    public HelpCircleAdapter(int layoutResId) {
        super(layoutResId);
    }

    public HelpCircleAdapter(Activity activity, @Nullable List<HelpCircleViewBean> data, RecyclerView recyclerView) {
        this(R.layout.item_focus, data);
        this.activity = activity;
        this.recyclerView = recyclerView;
    }

    @Override
    protected void convert(final BaseViewHolder helper, HelpCircleViewBean item) {
        isOpen = false;
        CircleImageView mIvPosterImg = helper.getView(R.id.mIvPosterImg);

        TextView mTvPosterName = helper.getView(R.id.mTvPosterName);

        mTvPosterName.setText(item.getPublisherNickname());
        TextView mTvPosterIntro = helper.getView(R.id.mTvPosterIntro);
        TextView mTvHelpReward = helper.getView(R.id.mTvHelpReward);
        mTvHelpReward.setText(item.getCoin_available());
        TextView mTvHelpRewardHint = helper.getView(R.id.mTvHelpRewardHint);
        TextView mTvHelpContent = helper.getView(R.id.mTvHelpContent);
        mTvHelpContent.setText(item.getHelpCircleContent());
        RecyclerView mRvHelpImg = helper.getView(R.id.mRvHelpImg);
        dealImgs(mRvHelpImg, item.getImg_url());
        TextView mTvHelpAddress = helper.getView(R.id.mTvHelpAddress);
        mTvHelpAddress.setText(item.getLocation_id());
        TextView mTvHelpRef = helper.getView(R.id.mTvHelpRef);
        TextView mTvHelpTimeAndSeenCount = helper.getView(R.id.mTvHelpTimeAndSeenCount);
        mTvHelpTimeAndSeenCount.setText(String.format("%s·%s人浏览", DateUtils.timeDiffText(
                TimeUtils.string2Date(item.getPublish_time()),
                new Date()), item.getView_times()));
        final TextView mWatchMoreTv = helper.getView(R.id.mWatchMoreTv);
        // 设置评论者的RecyclerView
        CommentRecyclerView mHelpCommentRv = helper.getView(R.id.mHelpCommentRv);
        mHelpCommentRv.setOnCommentClickListener(new CommentRecyclerView.OnCommentClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 点击评论时的操作.
                if (recyclerView != null) {
//                    ((MainActivity)activity).showDialog();
                    ((MainActivity) activity).showInputDialog(recyclerView, view, helper.getAdapterPosition(), position);

                } else {
                    ToastUtils.showShort("为什么总是为空啊");
                }
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        mHelpCommentRv.setLayoutManager(manager);
        final HelpCommentAdapter helpCommentAdapter = new HelpCommentAdapter(mHelpCommentRv);
        final List<HelpCircleMsgBean> msgBeans = item.getMsgBeans();
        if (msgBeans == null || msgBeans.size() == 0)
            return;
//        if (msgBeans.size() > 3) {
//            helpCommentAdapter.addData(msgBeans.subList(0, 2));
//            mWatchMoreTv.setVisibility(View.VISIBLE);
//        } else {
            helpCommentAdapter.addData(msgBeans);
//            mWatchMoreTv.setVisibility(View.GONE);
//        }
        mHelpCommentRv.setAdapter(helpCommentAdapter);


        mWatchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    // 已经展开 点击 就要收起
                    mWatchMoreTv.setText(String.format("查看更多%d条评论", msgBeans.size()-2));
                    helpCommentAdapter.setNewData(msgBeans.subList(0, 2));
                } else {
                    mWatchMoreTv.setText("收起评论");

                    helpCommentAdapter.setNewData(msgBeans);
                }
                isOpen = !isOpen;
            }
        });
    }

    private void dealImgs(RecyclerView mRvHelpImg, String img_url) {
        if (!TextUtils.isEmpty(img_url)) {
            String[] split = img_url.split(";");
            List<String> imgs = Arrays.asList(split);
            HelpCircleImgAdapter mAdapter = new HelpCircleImgAdapter(activity, imgs);
            if (imgs.size() <= 4 && imgs.size() != 3) {
                mRvHelpImg.setLayoutManager(new GridLayoutManager(activity, 2));
            } else {
                mRvHelpImg.setLayoutManager(new GridLayoutManager(activity, 3));
            }
            mRvHelpImg.setAdapter(mAdapter);
        }
    }
}
