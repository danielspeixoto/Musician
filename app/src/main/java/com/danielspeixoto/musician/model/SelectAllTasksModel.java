package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.ISelectAllModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class SelectAllTasksModel implements ISelectAllModel<Task> {

    private final DatabaseHandler mDBHandler;
    private final ISelectAllPresenter<Task> mSelectAllPresenter;

    public SelectAllTasksModel(ISelectAllPresenter mSelectAllPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mSelectAllPresenter = mSelectAllPresenter;
    }

    @Override
    public void selectAll() {
        SQLiteDatabase db = mDBHandler.getReadableDatabase();
        String[] projection = {
                Task._ID,
                Task.NAME,
                Task.DESCRIPTION
        };
        Cursor cursor = db.query(Task.TABLE,
                projection,
                null,
                null,
                null,
                null,
                Task._ID + " DESC"); // Order descending
        if (cursor.moveToFirst()) {
            do {
                mSelectAllPresenter.onReceiving(new Task(cursor));

            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}
