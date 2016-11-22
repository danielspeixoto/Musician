package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 22/11/16.
 */
public class UpdateTaskModel implements IUpdateModel<Task> {

    private final DatabaseHandler mDBHandler;
    private final IUpdatePresenter mUpdatePresenter;

    public UpdateTaskModel(IUpdatePresenter mUpdatePresenter, Context mContext) {
        this.mUpdatePresenter = mUpdatePresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void update(Task task) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.update(Task.TABLE,
                Convert.toContentValues(task),
                Task._ID + " = ?",
                new String[]{Integer.toString(task.getId())});
        mUpdatePresenter.onUpdated();
    }
}
