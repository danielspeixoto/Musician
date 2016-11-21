package com.danielspeixoto.musician.view.recycler.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.GetRelatedToDosPresenter;
import com.danielspeixoto.musician.view.recycler.holder.ToDoHolder;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class ToDoRecyclerAdapter extends RelatedRecyclerAdapter {

    public ToDoRecyclerAdapter(AppCompatActivity activity) {
        super(activity);
        mGetRelatedPresenter = new GetRelatedToDosPresenter(this, getActivity());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ToDo toDo = (ToDo) data.get(position);
        ToDoHolder toDoHolder = (ToDoHolder) holder;
        toDoHolder.setId(toDo.getId());
        toDoHolder.getToDoText().setText(toDo.getDescription());
        toDoHolder.getCheckBox().setChecked(toDo.isFinished());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ToDoHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_todo_item, parent, false),
                this);
    }

}
