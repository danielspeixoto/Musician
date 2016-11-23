package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.view.recycler.adapter.ToDoRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskDataActivity extends BaseActivity {

    private static final String SAVED_TO_DOS = "savedToDos";
    Task task = new Task();
    ToDoRecyclerAdapter mAdapter;
    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.descriptionEdit)
    EditText descriptionEdit;
    @BindView(R.id.toDoEdit)
    EditText toDoEdit;
    @BindView(R.id.toDoList)
    RecyclerView toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_data);
        ButterKnife.bind(this);
        mAdapter = new ToDoRecyclerAdapter(this);
        toDoList.setAdapter(mAdapter);
        toDoList.setLayoutManager(new LinearLayoutManager(this));
        if (savedInstanceState != null) {
            mAdapter.setData(savedInstanceState.getParcelableArrayList(SAVED_TO_DOS));
        }
    }

    @OnClick(R.id.addToDoButton)
    public void addToDo() {
        ToDo toDo = new ToDo(toDoEdit.getText().toString());
        mAdapter.newItem(toDo);
        toDoEdit.setText(EMPTY_STRING);
    }

    @OnClick(R.id.saveButton)
    public void saveTask() {
        task.setName(nameEdit.getText().toString());
        task.setDescription(descriptionEdit.getText().toString());
        task.setToDos(mAdapter.getData());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(SAVED_TO_DOS, mAdapter.getData());
    }
}
