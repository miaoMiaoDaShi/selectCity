package com.xxp.jiyi.pro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.xxp.jiyi.pro.adapter.assist.ViewHolder;

import java.util.List;

/**
 * Created by 钟大爷 on 2017/3/24.
 */

public abstract class AlmightyAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private final String TAG = "AlmightyAdapter";
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

    //item的布局id
    protected abstract int getRootViewId(int viewType);

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        View rootView = viewHolder.getRootView();
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: 点击了" );
                if (null!=onItemOnClickListener){
                    onItemOnClickListener.onClick(position);
                }
            }
        });
        rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemOnLongClickListener != null) {
                    onItemOnLongClickListener.onLongClick(position);
                }
                return true;
            }
        });
        convert(viewHolder, position, mDatas);
    }

    protected abstract void convert(ViewHolder viewHolder, int position, List<T> mDatas);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private OnItemOnClickListener onItemOnClickListener;
    private OnItemOnLongClickListener onItemOnLongClickListener;

    //设置点击事件
    public interface OnItemOnClickListener {
        void onClick(int position);
    }

    //长按
    public interface OnItemOnLongClickListener {
        void onLongClick(int position);
    }

    public void setOnItemOnClickListener(OnItemOnClickListener onItemOnClickListener) {
        this.onItemOnClickListener = onItemOnClickListener;
    }

    public void setOnItemOnLongClickListener(OnItemOnLongClickListener onItemOnLongClickListener) {
        this.onItemOnLongClickListener = onItemOnLongClickListener;
    }
}
