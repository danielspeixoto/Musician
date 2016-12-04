package com.danielspeixoto.musician.view.activity;

import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.InsertTaskPresenter;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class InsertTaskActivity extends TaskDataActivity implements IInsertView<Task> {

    @Override
    public void saveTask() {
        super.saveTask();
        new InsertTaskPresenter(this, this).insert(task);
    }

    @Override
    public void onObjectInserted(Task task) {
        showMessage("Task inserted");
        mAdapter.updateToDos();
        finish();
    }

    @Override
    public void onErrorInserting(String message) {
        showMessage(message);
    }
}