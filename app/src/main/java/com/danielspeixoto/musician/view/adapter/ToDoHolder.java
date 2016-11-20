package com.danielspeixoto.musician.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.danielspeixoto.musician.R;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class ToDoHolder extends BaseHolder {

    @BindView(R.id.toDoText)
    TextView toDoText;
    @BindView(R.id.checkBox)
    CheckBox checkBox;

    public ToDoHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }
}
