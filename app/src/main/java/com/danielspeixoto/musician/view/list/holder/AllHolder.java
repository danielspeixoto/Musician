package com.danielspeixoto.musician.view.list.holder;

import android.view.View;

import com.danielspeixoto.musician.view.list.adapter.BaseRecyclerAdapter;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public abstract class AllHolder extends BaseHolder implements IDeleteItemView {

    public static final String ID = "_id";

    public AllHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onItemDeleted() {
        mAdapter.refreshData();
    }

}
