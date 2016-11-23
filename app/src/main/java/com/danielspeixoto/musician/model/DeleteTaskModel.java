package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IDeleteModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.IDeletePresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class DeleteTaskModel implements IDeleteModel<Task> {

    private final DatabaseHandler mDBHandler;
    private IDeletePresenter mDeletePresenter;

    public DeleteTaskModel(IDeletePresenter mDeletePresenter, Context mContext) {
        this.mDeletePresenter = mDeletePresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.delete(Task.TABLE,
                Task._ID + " = ?",
                new String[]{Integer.toString(id)}
        );
        mDeletePresenter.onDeleted();
    }
}