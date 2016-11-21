package com.danielspeixoto.musician.view.recycler.holder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.dialog.BaseEditDeleteDialog;
import com.danielspeixoto.musician.view.module.IDeleteItemView;
import com.danielspeixoto.musician.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.OnClick;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public abstract class AllHolder extends BaseHolder implements IDeleteItemView {

    public static final String ID = "_id";
    protected BaseEditDeleteDialog dialog;

    public AllHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @OnClick(R.id.optionsButton)
    public void optionsButtonAction() {
        Bundle bundle = new Bundle();
        bundle.putInt(ID, id);
        dialog.setArguments(bundle);
        dialog.show(mAdapter.getActivity().getSupportFragmentManager(), dialog.TAG);
    }

    protected void getInfo(Class clazz) {
        Intent intent = new Intent(mAdapter.getActivity(), clazz);
        intent.putExtra(ID, id);
        mAdapter.getActivity().startActivity(intent);
    }

    @Override
    public void refreshData() {
        mAdapter.refreshData();
    }

}
