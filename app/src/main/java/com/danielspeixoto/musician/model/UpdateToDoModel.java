package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class UpdateToDoModel implements IUpdateModel<ToDo> {

    private final DatabaseHandler mDBHandler;
    private final IUpdatePresenter mUpdatePresenter;

    public UpdateToDoModel(IUpdatePresenter mUpdatePresenter, Context mContext) {
        this.mUpdatePresenter = mUpdatePresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void update(ToDo toDo) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        db.update(ToDo.TABLE,
                Convert.toContentValues(toDo),
                ToDo._ID + " = ?",
                new String[]{Integer.toString(toDo.getId())});
        mUpdatePresenter.onUpdated();
    }
}
