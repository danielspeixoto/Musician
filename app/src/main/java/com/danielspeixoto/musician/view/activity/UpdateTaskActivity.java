package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;

import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.UpdateTaskPresenter;
import com.danielspeixoto.musician.view.module.IUpdateView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class UpdateTaskActivity extends TaskDataActivity implements IUpdateView<Task> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        task = getIntent().getParcelableExtra(Task.TABLE);
        mAdapter.setRelationId(task.getId());
        fillData(task);
        if (savedInstanceState == null) {
            mAdapter.refreshData();
        }
    }

    @Override
    public void saveTask() {
        super.saveTask();
        new UpdateTaskPresenter(this, this).update(task);
    }

    public void fillData(Task task) {
        nameEdit.setText(task.getName());
        descriptionEdit.setText(task.getDescription());
    }

    @Override
    public void onObjectUpdated() {
        showMessage("Task has been updated");
        mAdapter.updateToDos();
        finish();
    }

    @Override
    public void onErrorUpdating(String message) {
        showMessage(message);
    }
}
