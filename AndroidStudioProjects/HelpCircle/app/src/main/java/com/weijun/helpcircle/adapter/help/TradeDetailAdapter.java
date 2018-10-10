package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.FriendGetBean;
import com.weijun.helpcircle.pojo.TradeDetailResponseBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TradeDetailAdapter extends BaseQuickAdapter<TradeDetailResponseBean, BaseViewHolder> {
    public TradeDetailAdapter(@Nullable List<TradeDetailResponseBean> data) {
        super(R.layout.item_trade_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TradeDetailResponseBean item) {
        TextView mTvType = helper.getView(R.id.mTvType);
        TextView mTvTime = helper.getView(R.id.mTvTime);
        TextView mTvAmount = helper.getView(R.id.mTvAmount);
        String type = dealType(mTvType, item.getType());
        mTvType.setText(type);
        mTvTime.setText(item.getCtime());
        mTvAmount.setText(item.getAmount());

    }

    private String dealType(TextView mTvType, String type) {
        // type=1=注册奖励; type=2=邀请奖励; type=3=转发奖励;  发生数为负数的场景: 101=发布消息
        if (TextUtils.isEmpty(type))
            return "";
        if (type.equals("101")) {
            return "发布消息";
        }
        if (type.equals("1"))
            return "注册奖励";

        if (type.equals("2"))
            return "邀请奖励";

        if (type.equals("3"))
            return "转发奖励";
        return "其他";
    }
}
