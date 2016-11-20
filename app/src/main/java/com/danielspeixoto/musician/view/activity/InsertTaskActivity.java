package com.danielspeixoto.musician.view.activity;

import com.danielspeixoto.musician.presenter.InsertTaskPresenter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class InsertTaskActivity extends TaskDataActiviy {

    @Override
    public void saveTask() {
        super.saveTask();
        new InsertTaskPresenter(this, this).insert(task);
        finish();
    }
}