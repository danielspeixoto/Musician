package com.danielspeixoto.musician.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.util.Convert;
import com.danielspeixoto.musician.util.DatabaseHandler;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class InsertTaskModel implements IInsertModel<Task> {

    private final DatabaseHandler mDBHandler;
    private final IInsertPresenter mInsertPresenter;

    public InsertTaskModel(IInsertPresenter mInsertPresenter, Context mContext) {
        this.mInsertPresenter = mInsertPresenter;
        this.mDBHandler = new DatabaseHandler(mContext);
    }

    @Override
    public void insert(Task task) {
        SQLiteDatabase db = mDBHandler.getWritableDatabase();
        long parentId = db.insert(Task.TABLE, null, Convert.toContentValues(task));
        for (ToDo todo : task.getToDos()) {
            todo.setTaskId(parentId);
            db.insert(ToDo.TABLE, null, Convert.toContentValues(todo));
        }
        mInsertPresenter.onInserted();
    }

}
