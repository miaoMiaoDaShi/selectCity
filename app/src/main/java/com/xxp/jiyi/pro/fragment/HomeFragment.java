package com.xxp.jiyi.pro.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.xxp.jiyi.R;
import com.xxp.jiyi.pro.adapter.AlmightyAdapter;
import com.xxp.jiyi.pro.adapter.assist.ViewHolder;
import com.xxp.jiyi.pro.entity.NotesData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by 钟大爷 on 2017/3/23.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rvNotes;

    private List<NotesData> mNotes;
    private final String TAG = "HomeFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recylerview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onViewCreated: ");
        initData();
        initRecylerView();
    }

    private void initData() {
        mNotes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mNotes.add(
                    new NotesData(0, "2017.03.24", "在这快节奏互联网的时代中，" +
                            "写日记的习惯已快在上班族人群中消失，休闲时间更多的是看电影，" +
                            "听音乐，打游戏；“吾皇日记”为你打造一个轻松的写作平台，" +
                            "让你方便快捷的记录生活，体验人生。", "10:31"));
        }
        Log.e(TAG, "initData: " + mNotes.size());
    }

    private void initRecylerView() {
        rvNotes.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvNotes.setAdapter(new AlmightyAdapter<NotesData>(mNotes, getActivity()) {
            @Override
            protected int getRootViewId(int viewType) {
                return R.layout.item_note;
            }

            @Override
            protected void convert(ViewHolder viewHolder, int position, List<NotesData> mDatas) {
                viewHolder.setText(R.id.tv_date, mDatas.get(position).getDate());
                viewHolder.setText(R.id.tv_content, mDatas.get(position).getContent());
                viewHolder.setText(R.id.tv_time, mDatas.get(position).getTime());
            }
        });
    }
}
