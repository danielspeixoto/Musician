package com.danielspeixoto.musician.view.recycler.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import lombok.Getter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class ToDoHolder extends BaseHolder {

    @BindView(R.id.toDoText)
    @Getter
    TextView toDoText;
    @BindView(R.id.checkBox)
    @Getter
    CheckBox checkBox;

    public ToDoHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }
}
