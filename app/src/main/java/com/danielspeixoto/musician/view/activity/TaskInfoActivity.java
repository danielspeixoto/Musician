package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.view.list.adapter.ToDoRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskInfoActivity extends BaseActivity {

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.descriptionText)
    TextView descriptionText;
    @BindView(R.id.toDoList)
    RecyclerView toDoList;
    private ToDoRecyclerAdapter mAdapter;
    private Task mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);
        ButterKnife.bind(this);
        mTask = getIntent().getExtras().getParcelable(Task.TABLE);
        fillData();
        mAdapter = new ToDoRecyclerAdapter(this);
        mAdapter.setRelationId(mTask.getId());
        toDoList.setLayoutManager(new LinearLayoutManager(this));
        toDoList.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.refreshData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.updateToDos();
    }

    public void fillData() {
        nameText.setText(mTask.getName());
        if (!mTask.getDescription().equals(EMPTY_STRING)) {
            descriptionText.setVisibility(View.VISIBLE);
            descriptionText.setText(mTask.getDescription());
        }
    }
}
