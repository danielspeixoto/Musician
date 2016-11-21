package com.danielspeixoto.musician.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.danielspeixoto.musician.view.recycler.adapter.BaseRecyclerAdapter;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class ListFragment extends Fragment {

    protected BaseRecyclerAdapter mAdapter;
    protected RecyclerView list;

    protected void setUpList() {
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.refreshData();
    }
}