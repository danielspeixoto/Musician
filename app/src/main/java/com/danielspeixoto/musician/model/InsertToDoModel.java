package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 22/11/16.
 */
public class InsertToDoModel implements IInsertModel<ToDo> {

    private final DatabaseHandler mDBHandler;
    private final IInsertPresenter mInsertPresenter;

    public InsertToDoModel(IInsertPresenter mInsertPresenter, Context mContext) {
        this.mInsertPresenter = mInsertPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void insert(ToDo toDo) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        mInsertPresenter.onInserted(db.insert(ToDo.TABLE, null, Convert.toContentValues(toDo)));
    }

}