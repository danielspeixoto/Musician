package com.danielspeixoto.musician.view.list.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.list.holder.DrawerHolder;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerRecyclerAdapter extends BaseRecyclerAdapter {

    public DrawerRecyclerAdapter(AppCompatActivity activity) {
        super(activity);
        addItem("A");
        addItem("B");
        addItem("C");
    }

    @Override
    public void refreshData() {
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String item = (String) data.get(position);
        DrawerHolder itemHolder = (DrawerHolder) holder;
        itemHolder.setId(position);
        itemHolder.setIndex(position);
        itemHolder.getDrawerText().setText(item);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrawerHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_drawer_item, parent, false),
                this);
    }
}
