package com.weijun.helpcircle.adapter.help;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.weijun.helpcircle.ui.fragment.InteractFragment;

import java.util.ArrayList;
import java.util.List;

public class InteractPageAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments = new ArrayList<>();

    public InteractPageAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new InteractFragment());
        fragments.add(new InteractFragment());
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
