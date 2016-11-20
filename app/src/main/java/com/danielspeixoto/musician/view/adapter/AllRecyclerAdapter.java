package com.danielspeixoto.musician.view.adapter;

import android.support.v7.app.AppCompatActivity;

import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class AllRecyclerAdapter extends BaseRecyclerAdapter {

    protected ISelectAllPresenter mSelectAllPresenter;

    public AllRecyclerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void refreshData() {
        data.clear();
        mSelectAllPresenter.selectAll();
        notifyDataSetChanged();
    }
}
