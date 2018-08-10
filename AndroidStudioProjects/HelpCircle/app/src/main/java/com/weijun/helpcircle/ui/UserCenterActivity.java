package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.view.popupwindow.BottomPopup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserCenterActivity extends BaseActivity {

    @BindView(R.id.iv_parallax)
    ImageView ivParallax;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.nickname)
    TextView nickname;
    @BindView(R.id.rl_allinfo)
    RelativeLayout rlAllinfo;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar_avatar)
    ImageView toolbarAvatar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout buttonBarLayout;
    @BindView(R.id.iv_date)
    ImageView ivDate;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.mRv)
    RecyclerView mRv;
    private ImmersionBar mImmersionBar;
    boolean isBlack = false;//状态栏字体是否是黑色
    boolean isWhite = true;//状态栏字体是否是亮色
    private BottomPopup bottomPopup;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_user_center);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initView();
    }

    @Override
    protected void initView() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.titleBar(toolbar);
//        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
//            @Override
//            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int bottomHeight, int extendHeight) {
////                mOffset = offset / 2;
//                ivParallax.setTranslationY(offset);
//            }
//            @Override
//            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int bottomHeight, int extendHeight) {
////                mOffset = offset / 2;
//                ivParallax.setTranslationY(offset);
//            }
//        });
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                ivParallax.setTranslationY(verticalOffset);
                //200是appbar的高度
                if (Math.abs(verticalOffset) == DensityUtil.dp2px(400) - toolbar.getHeight()) {//关闭
                    if (isWhite) {//变黑
                        if (ImmersionBar.isSupportStatusBarDarkFont()) {
                            mImmersionBar.statusBarDarkFont(true).init();
                            isBlack = true;
                            isWhite = false;
                        }
                    }
                    buttonBarLayout.setVisibility(View.VISIBLE);
                    collapsingToolbar.setContentScrimResource(R.color.white);
                    ivBack.setBackgroundResource(R.drawable.ic_back);
                    ivDate.setBackgroundResource(R.drawable.set_write);
//                    toolbar.setVisibility(View.VISIBLE);
                } else {  //展开
                    if (isBlack) { //变白
                        mImmersionBar.statusBarDarkFont(false).init();
                        isBlack = false;
                        isWhite = true;
                    }
                    buttonBarLayout.setVisibility(View.INVISIBLE);
                    collapsingToolbar.setContentScrimResource(R.color.transparent_background);
                    ivBack.setBackgroundResource(R.drawable.ic_back);
                    ivDate.setBackgroundResource(R.drawable.set_write);
//                    toolbar.setVisibility(View.INVISIBLE);
                }
            }
        });

        initRv();

    }

    private void initRv() {
        mRv.setLayoutManager(new LinearLayoutManager(this));
    }


    @OnClick({R.id.mTvEdit, R.id.mLLCode, R.id.mLLPrivate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvEdit:
                break;
            case R.id.mLLCode:
                break;
            case R.id.mLLPrivate:
                showBottomPic();

                break;
        }
    }

    private void showBottomPic() {
        if (bottomPopup == null) {
            bottomPopup = new BottomPopup(this, new BottomPopup.OnItemClickListener() {
                @Override
                public void onItemOneClick() {

                }

                @Override
                public void onItemTwoClick() {

                }

                @Override
                public void onItemCancelClick() {

                }
            });
        }
        bottomPopup.show(findViewById(R.id.mRootView));
    }
}
