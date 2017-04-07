package com.xxp.jiyi.pro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xxp.jiyi.R;

import butterknife.BindView;

/**
 * Created by 钟大爷 on 2017/3/23.
 */

public class MoodFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rvNotes;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recylerview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }
}
