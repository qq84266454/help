package com.weijun.helpcircle.adapter.help;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.event.BusProvider;
import com.weijun.helpcircle.event.EventBusInfo;
import com.weijun.helpcircle.event.EventType;
import com.weijun.helpcircle.http.ApiRequest;
import com.weijun.helpcircle.http.ApiService;
import com.weijun.helpcircle.pojo.HelpCircleMsgBean;
import com.weijun.helpcircle.view.CircleMovementMethod;
import com.weijun.helpcircle.view.Clickable;
import com.weijun.helpcircle.view.CommentRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpCommentAdapter extends BaseQuickAdapter<HelpCircleMsgBean, BaseViewHolder> {
    private CommentRecyclerView recyclerView;

    public HelpCommentAdapter(int layoutResId, @Nullable List<HelpCircleMsgBean> data) {
        super(layoutResId, data);
    }

    public HelpCommentAdapter(@Nullable List<HelpCircleMsgBean> data) {
        this(R.layout.item_help_comment, data);
    }

    public HelpCommentAdapter(int layoutResId) {
        super(layoutResId);
    }

    public HelpCommentAdapter(CommentRecyclerView recyclerView) {
        super(R.layout.item_help_comment);
        this.recyclerView = recyclerView;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final HelpCircleMsgBean msgBean) {
        final String reply_nick_name = msgBean.getReply_nick_name();
        final TextView mCommentNameTv = helper.getView(R.id.mCommentNameTv);
        SpannableString ss;
        final Clickable clickable = new Clickable(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView != null)
                    recyclerView.clickComment(mCommentNameTv, helper.getAdapterPosition());
                else
                    ToastUtils.showShort("竟然为空了? ");
            }
        }, Color.parseColor("#747474"));
        if (msgBean.getRecieve_id() != null) {
            final String recieve_nick_name = msgBean.getRecieve_nick_name();
            ss = new SpannableString(String.format("%s 回复 %s : %s", reply_nick_name,
                    recieve_nick_name, msgBean.getReply_content()));
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

            ss.setSpan(clickable, recieve_nick_name.length() + reply_nick_name.length() + 6, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            ss = new SpannableString(String.format("%s : %s", reply_nick_name, msgBean.getReply_content()));
            ss.setSpan(new Clickable(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showShort(msgBean.getReply_nick_name());
                }
            }), 0, reply_nick_name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(clickable, reply_nick_name.length() + 3, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        mCommentNameTv.setText(ss);
        mCommentNameTv.setMovementMethod(new CircleMovementMethod(0xffcccccc, 0xffcccccc));
    }

    private void doAddMsg(String reciever_id, String help_circle_id, String reply_content) {
        ApiService apiService = ApiRequest.getInstance().create(ApiService.class);
        Map<String, String> map = new HashMap<>();
        map.put("operate", "helpCircleMsgAdd");
        map.put("version", "1.1");
        map.put("user_id", "2");
        map.put("reciever_id", reciever_id);
        map.put("help_circle_id", help_circle_id);
        map.put("reply_content", reply_content);
        apiService.doHelpCircleMsgAdd(map);
    }
}
