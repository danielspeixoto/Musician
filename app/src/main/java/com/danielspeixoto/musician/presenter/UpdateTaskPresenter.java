package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateTaskModel;
import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.view.module.IToastView;

/**
 * Created by danielspeixoto on 22/11/16.
 */
public class UpdateTaskPresenter implements IUpdatePresenter<Task> {

    private final IToastView mToastView;
    private final IUpdateModel mUpdateModel;

    public UpdateTaskPresenter(IToastView mToastView, Context mContext) {
        this.mToastView = mToastView;
        this.mUpdateModel = new UpdateTaskModel(this, mContext);
    }

    @Override
    public void update(Task task) {
        mUpdateModel.update(task);
    }

    @Override
    public void onUpdated() {
        mToastView.showMessage("Task has been updated");
    }

}