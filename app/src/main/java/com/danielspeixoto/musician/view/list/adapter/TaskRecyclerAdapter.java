package com.danielspeixoto.musician.view.list.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.AllTasksPresenter;
import com.danielspeixoto.musician.view.list.holder.TaskHolder;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class TaskRecyclerAdapter extends AllRecyclerAdapter {

    public TaskRecyclerAdapter(AppCompatActivity activity) {
        super(activity);
        mSelectAllPresenter = new AllTasksPresenter(this, getActivity());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Task task = (Task) data.get(position);
        TaskHolder taskHolder = (TaskHolder) holder;
        taskHolder.setId(task.getId());
        taskHolder.setIndex(position);
        taskHolder.getTaskName().setText(task.getName());
        taskHolder.getTaskDescription().setText(task.getDescription());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_task_item, parent, false),
                this);
    }
}
