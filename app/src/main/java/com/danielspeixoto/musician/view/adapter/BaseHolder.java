package com.danielspeixoto.musician.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import lombok.Setter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class BaseHolder extends RecyclerView.ViewHolder {

    @Setter
    protected int id;
    protected BaseRecyclerAdapter mAdapter;

    public BaseHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
        ButterKnife.bind(this, itemView);
    }

}
