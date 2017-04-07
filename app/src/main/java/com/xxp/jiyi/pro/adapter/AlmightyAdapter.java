package com.xxp.jiyi.pro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.xxp.jiyi.pro.adapter.assist.ViewHolder;

import java.util.List;

/**
 * Created by 钟大爷 on 2017/3/24.
 */

public abstract class AlmightyAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private List<T> mDatas;
    private Context mContext;

    public AlmightyAdapter(List<T> mDatas, Context context) {
        this.mDatas = mDatas;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.createViewHolder(mContext, parent, getRootViewId(viewType));
        return viewHolder;
    }

    //
    protected abstract int getRootViewId(int viewType);

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        convert(viewHolder,position,mDatas);
    }

    protected abstract void convert(ViewHolder viewHolder, int position, List<T> mDatas);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

}
