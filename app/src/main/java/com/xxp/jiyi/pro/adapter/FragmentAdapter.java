package com.xxp.jiyi.pro.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.xxp.jiyi.R;
import com.xxp.jiyi.pro.utils.UIUtils;

import java.util.List;

/**
 * Created by 钟大爷 on 2017/3/24.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> tabs;
    private String titles[];

    public FragmentAdapter(FragmentManager fm,List<Fragment> tabs) {
        super(fm);
        this.tabs = tabs;
        titles = UIUtils.getStringArray(R.array.tabs_title);

    }


    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
