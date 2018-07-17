package com.weijun.helpcircle.adapter.community;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.weijun.helpcircle.ui.fragment.SubCommunityFragment;

import java.util.ArrayList;
import java.util.List;

public class CommunityAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments = new ArrayList<>();
    public CommunityAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new SubCommunityFragment());
        fragments.add(new SubCommunityFragment());
        fragments.add(new SubCommunityFragment());
        fragments.add(new SubCommunityFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
