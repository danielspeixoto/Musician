package com.danielspeixoto.musician.view.list.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.danielspeixoto.musician.view.list.adapter.BaseRecyclerAdapter;

import butterknife.ButterKnife;
import lombok.Setter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class BaseHolder extends RecyclerView.ViewHolder {

    @Setter
    protected long id;
    @Setter
    protected int index;
    protected BaseRecyclerAdapter mAdapter;

    public BaseHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
        ButterKnife.bind(this, itemView);
    }

}
