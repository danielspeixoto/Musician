package com.danielspeixoto.musician.view.recycler.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.GetRelatedToDosPresenter;
import com.danielspeixoto.musician.presenter.UpdateToDoPresenter;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.view.module.IToastView;
import com.danielspeixoto.musician.view.recycler.holder.ToDoHolder;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class ToDoRecyclerAdapter extends RelatedRecyclerAdapter implements IToastView {

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

    @Override
    public void addItem(Object object) {
        // new InsertToDoPresenter(this, getActivity()).insert((ToDo)object);
        ((ToDo) object).setTaskId(relationId);
        super.addItem(object);
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
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
