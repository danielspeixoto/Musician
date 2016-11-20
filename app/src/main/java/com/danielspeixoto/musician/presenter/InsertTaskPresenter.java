package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertTaskModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.view.module.IToastView;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class InsertTaskPresenter implements IInsertPresenter<Task> {

    private final IToastView mToastView;
    private IInsertModel mInsertModel;

    public InsertTaskPresenter(IToastView mToastView, Context mContext) {
        this.mToastView = mToastView;
        this.mInsertModel = new InsertTaskModel(this, mContext);
    }

    @Override
    public void insert(Task task) {
        mInsertModel.insert(task);
    }

    @Override
    public void onInserted() {
        mToastView.showMessage("Task created");
    }
}
