package com.danielspeixoto.musician.view.recycler.holder;

import android.view.View;

import com.danielspeixoto.musician.view.module.IDeleteItemView;
import com.danielspeixoto.musician.view.recycler.adapter.BaseRecyclerAdapter;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public abstract class AllHolder extends BaseHolder implements IDeleteItemView {

    public static final String ID = "_id";

    public AllHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @Override
    public void onItemDeleted() {
        mAdapter.refreshData();
    }

}
