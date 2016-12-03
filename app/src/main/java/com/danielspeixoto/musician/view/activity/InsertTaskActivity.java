package com.danielspeixoto.musician.view.activity;

import android.widget.Toast;

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
        finish();
    }

    @Override
    public void onObjectInserted(Task task) {
        Toast.makeText(getApplicationContext(), "Task inserted", Toast.LENGTH_LONG).show();
    }
}