package com.xxp.jiyi.pro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.xxp.jiyi.R;
import com.xxp.jiyi.pro.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 钟大爷 on 2017/3/23.
 */

public class MeiwenFragment extends BaseFragment {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    private List<Fragment> mTabs;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_meiwen;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTabs();
    }

    private void initTabs() {
        mTabs = new ArrayList<>();
        Fragment fragment = null;
        Bundle bundle = null;
        for (int i = 0; i < 6; i++) {
            bundle = new Bundle();
            bundle.putInt("type", i);
            fragment = new RecylerViewFragment();
            fragment.setArguments(bundle);
            mTabs.add(fragment);
            bundle.clear();
        }
        vpContent.setAdapter(new FragmentAdapter(getFragmentManager(), mTabs));
        tabs.setupWithViewPager(vpContent);
    }

}
