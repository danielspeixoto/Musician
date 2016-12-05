package com.danielspeixoto.musician.view.list.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.view.list.adapter.ToDoRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
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

    public ToDoHolder(View itemView, ToDoRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @OnClick(R.id.checkBox)
    public void checkboxClicked() {
        ((ToDo) mAdapter.getData().get(index)).setFinished(checkBox.isChecked());
    }

    @OnClick(R.id.removeToDo)
    public void removeToDo() {
        ((ToDoRecyclerAdapter) mAdapter).removeItem(id, index);
    }
}
