package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertTaskModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.util.Auth;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class InsertTaskPresenter implements IInsertPresenter<Task> {

    private final IInsertView<Task> mInsertView;
    private final IInsertModel<Task> mInsertModel;
    private Task mTask;

    public InsertTaskPresenter(IInsertView mInsertView, Context mContext) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertTaskModel(this, mContext);
    }

    @Override
    public void insert(Task task) {
        mTask = task;
        if (Auth.verifyItem(task)) {
            mInsertModel.insert(task);
        } else {
            mInsertView.onError("Must have a name");
        }
    }

    @Override
    public void onInserted(long id) {
        mInsertView.onObjectInserted(mTask);
    }
}
