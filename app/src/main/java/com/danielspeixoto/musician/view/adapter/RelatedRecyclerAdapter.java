package com.danielspeixoto.musician.view.adapter;

import android.support.v7.app.AppCompatActivity;

import com.danielspeixoto.musician.presenter.module.IGetRelatedPresenter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class RelatedRecyclerAdapter extends BaseRecyclerAdapter {

    protected int relationId;
    protected IGetRelatedPresenter mGetRelatedPresenter;

    public RelatedRecyclerAdapter(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void refreshData() {
        data.clear();
        mGetRelatedPresenter.getRelated(relationId);
        notifyDataSetChanged();
    }
}
