package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IGetRelatedModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IGetRelatedPresenter;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class GetRelatedToDosModel implements IGetRelatedModel<ToDo> {

    private final DatabaseHandler mDBHandler;
    private final IGetRelatedPresenter<ToDo> mGetRelatedPresenter;

    public GetRelatedToDosModel(IGetRelatedPresenter mGetRelatedPresenter, Context mContext) {
        this.mDBHandler = new DatabaseHandler(mContext);
        this.mGetRelatedPresenter = mGetRelatedPresenter;
    }

    @Override
    public void getRelated(int parentIndex) {
        SQLiteDatabase db = mDBHandler.getReadableDatabase();
        String[] projection = {
                ToDo._ID,
                ToDo.DESCRIPTION,
                ToDo.IS_FINISHED
        };
        Cursor cursor = db.query(ToDo.TABLE,
                projection,
                ToDo.TASK_ID + " = ?",
                new String[]{Integer.toString(parentIndex)},
                null,
                null,
                ToDo._ID);
        if (cursor.moveToFirst()) {
            do {
                mGetRelatedPresenter.onReceiving(new ToDo(cursor));
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}