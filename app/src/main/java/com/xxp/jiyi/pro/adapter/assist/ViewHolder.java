package com.xxp.jiyi.pro.adapter.assist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 钟大爷 on 2017/3/27.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private Context mContext;
    private View mRootView;

    private ViewHolder(View itemView, Context context) {
        super(itemView);
        mViews = new SparseArray<>();
        mRootView = itemView;
        mContext = context;
    }

    public static ViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false), context);
        return holder;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mRootView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getRootView() {
        return mRootView;
    }

    public void setText(int viewId, String text) {
        ((TextView) getView(viewId)).setText(text);
    }
}
