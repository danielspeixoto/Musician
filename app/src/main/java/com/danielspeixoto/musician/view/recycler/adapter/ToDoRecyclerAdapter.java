package com.danielspeixoto.musician.view.recycler.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.GetRelatedToDosPresenter;
import com.danielspeixoto.musician.presenter.InsertToDoPresenter;
import com.danielspeixoto.musician.presenter.UpdateToDoPresenter;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.view.module.IInsertView;
import com.danielspeixoto.musician.view.module.IUpdateView;
import com.danielspeixoto.musician.view.recycler.holder.ToDoHolder;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class ToDoRecyclerAdapter extends RelatedRecyclerAdapter implements IInsertView<ToDo>,
        IUpdateView {

    public ToDoRecyclerAdapter(AppCompatActivity activity) {
        super(activity);
        mGetRelatedPresenter = new GetRelatedToDosPresenter(this, getActivity());
    }

    public void updateToDos() {
        new Thread(() -> {
            IUpdatePresenter<ToDo> updatePresenter = new UpdateToDoPresenter(this, getActivity());
            for (ToDo toDo : (ArrayList<ToDo>) data) {
                updatePresenter.update(toDo);
            }
        }).run();
    }


    public void newItem(ToDo toDo) {
        toDo.setTaskId(relationId);
        new InsertToDoPresenter(this, getActivity()).insert(toDo);
    }

    @Override
    public void onObjectInserted(ToDo toDo) {
        super.addItem(toDo);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ToDo toDo = (ToDo) data.get(position);
        ToDoHolder toDoHolder = (ToDoHolder) holder;
        toDoHolder.setId(toDo.getId());
        toDoHolder.setIndex(position);
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

    @Override
    public void onObjectUpdated() {
    }
}
