package com.danielspeixoto.musician.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList mData = new ArrayList<>();
    private Activity mActivity;

    public BaseRecyclerAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void addItem(Object object) {
        mData.add(object);
        updateList();
    }

    public void removeAll() {
        mData.clear();
        updateList();
    }

    private void updateList() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
