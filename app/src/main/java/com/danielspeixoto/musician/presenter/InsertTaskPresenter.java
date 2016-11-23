package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertTaskModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class InsertTaskPresenter implements IInsertPresenter<Task> {

    private final IInsertView mInsertView;
    private Task mTask;
    private IInsertModel<Task> mInsertModel;
    private IInsertPresenter<ToDo> mInsertToDoPresenter;

    public InsertTaskPresenter(IInsertView mInsertView, Context mContext) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertTaskModel(this, mContext);
        this.mInsertToDoPresenter = new InsertToDoPresenter(mInsertView, mContext);
    }

    @Override
    public void insert(Task task) {
        mTask = task;
        mInsertModel.insert(task);
    }

    @Override
    public void onInserted(long id) {
        for (ToDo toDo : mTask.getToDos()) {
            toDo.setTaskId(id);
            mInsertToDoPresenter.insert(toDo);
        }
        mInsertView.onObjectInserted(mTask);
    }
}
