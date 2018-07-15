package com.weijun.helpcircle.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.InteractPageAdapter;
import com.weijun.helpcircle.base.BaseActivity;
import com.weijun.helpcircle.ui.fragment.HelpAwardFragment;
import com.weijun.helpcircle.ui.fragment.HelpFocusFragment;
import com.weijun.helpcircle.ui.fragment.HelpRewardFragment;
import com.weijun.helpcircle.ui.fragment.InteractFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InteractActivity extends BaseActivity {

    @BindView(R.id.mTvLeft)
    TextView mTvLeft;
    @BindView(R.id.mLLLeft)
    LinearLayout mLLLeft;
    @BindView(R.id.mTvRight)
    TextView mTvRight;
    @BindView(R.id.mLLRight)
    LinearLayout mLLRight;
    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mTab)
    CommonTabLayout mTab;
    @BindView(R.id.mVp)
    ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initView() {
        initTitle();
        initTab();
        initViewPager();
    }

    private void initTitle() {
        mTvLeft.setVisibility(View.GONE);
        mTvTitle.setText("互动过的人");
        mTvRight.setVisibility(View.GONE);
    }

    private void initViewPager() {
        mVp.setAdapter(new InteractPageAdapter(getSupportFragmentManager()));
        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initTab() {
//        ArrayList<Fragment> fragments = new ArrayList<>();
        final String[] titles = new String[]{"助力过的人", "转发过的人"};
//        fragments.add(new InteractFragment());
//        fragments.add(new InteractFragment());
        ArrayList<CustomTabEntity> tabEntitys = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            final int finalI = i;
            tabEntitys.add(new CustomTabEntity() {
                @Override
                public String getTabTitle() {
                    return titles[finalI];
                }

                @Override
                public int getTabSelectedIcon() {
                    return 0;
                }

                @Override
                public int getTabUnselectedIcon() {
                    return 0;
                }
            });
        }
        mTab.setTabData(tabEntitys);
    }
}
