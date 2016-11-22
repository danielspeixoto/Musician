package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;

import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.UpdateTaskPresenter;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class UpdateTaskActivity extends TaskDataActivity {

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
        mAdapter.updateToDos();
        finish();
    }

    public void fillData(Task task) {
        nameEdit.setText(task.getName());
        descriptionEdit.setText(task.getDescription());
    }
}
