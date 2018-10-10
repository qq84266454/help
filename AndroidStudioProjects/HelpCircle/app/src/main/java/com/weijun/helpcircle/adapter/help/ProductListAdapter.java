package com.weijun.helpcircle.adapter.help;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.http.InterfaceParameters;
import com.weijun.helpcircle.pojo.FriendGetBean;
import com.weijun.helpcircle.pojo.ProductListResponseBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductListAdapter extends BaseQuickAdapter<ProductListResponseBean, BaseViewHolder> {
    public ProductListAdapter(@Nullable List<ProductListResponseBean> data) {
        super(R.layout.item_product_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductListResponseBean item) {
        final String d_type = item.getD_type();
        View mLLType1 = helper.getView(R.id.mLLType1);
        View mLLType2 = helper.getView(R.id.mLLType2);
        final boolean hasBought = "2".equals(d_type);
        if (!hasBought) {
            helper.getView(R.id.mIvHasBought).setVisibility(View.GONE);
            mLLType1.setVisibility(View.VISIBLE);
            mLLType2.setVisibility(View.GONE);

        } else {
            helper.getView(R.id.mIvHasBought).setVisibility(View.VISIBLE);
            mLLType1.setVisibility(View.GONE);
            mLLType2.setVisibility(View.VISIBLE);
        }
        TextView mTvTitle = helper.getView(R.id.mTvTitle);
        TextView mTvDetail = helper.getView(R.id.mTvDetail);
        TextView mTvCostValue = helper.getView(R.id.mTvCostValue);
        TextView mTvCT = helper.getView(R.id.mTvCT);
        mTvTitle.setText(item.getTitle());
        mTvDetail.setText(item.getDetail());
        mTvCostValue.setText(item.getCharge());
        mTvCT.setText(item.getCt());

        Picasso.get().load(InterfaceParameters.BASE_URL_IMG + item.getCompany_url())
                .into((ImageView) helper.getView(R.id.mIvCompany));

        helper.getView(R.id.mLLRootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasBought) {
                    ToastUtils.showShort("待定");
                }
            }
        });
    }

}
