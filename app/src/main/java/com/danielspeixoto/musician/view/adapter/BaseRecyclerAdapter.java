package com.danielspeixoto.musician.view.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;
import com.danielspeixoto.musician.view.module.IListView;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements IListView {

    @Getter
    protected AppCompatActivity activity;
    protected ISelectAllPresenter mSelectAllPresenter;
    protected ArrayList mData = new ArrayList<>();

    public BaseRecyclerAdapter(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void addItem(Object object) {
        mData.add(object);
        activity.runOnUiThread(() -> notifyDataSetChanged());
    }

    public void refreshData() {
        mData.clear();
        mSelectAllPresenter.selectAll();
        notifyDataSetChanged();
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
