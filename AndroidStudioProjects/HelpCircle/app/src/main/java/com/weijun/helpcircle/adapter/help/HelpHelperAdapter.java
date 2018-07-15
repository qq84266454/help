package com.weijun.helpcircle.adapter.help;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.pojo.User;
import com.weijun.helpcircle.utils.glideutils.ShowImageUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HelpHelperAdapter extends BaseQuickAdapter<User, BaseViewHolder> {

    private Activity activity;

    public HelpHelperAdapter(Activity activity, @Nullable List data) {
        super(R.layout.item_help_helpers, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        CircleImageView imageView = helper.getView(R.id.mCivHelper);
        ShowImageUtils.showImageView(activity, R.color.black, item.getImg(), imageView);
    }
}
