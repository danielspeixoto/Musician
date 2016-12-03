package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.DeleteTaskModel;
import com.danielspeixoto.musician.model.module.IDeleteModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.IDeletePresenter;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class DeleteTaskPresenter implements IDeletePresenter<Task> {

    private final IDeleteItemView mDeleteItemView;
    private IDeleteModel mDeleteModel;

    public DeleteTaskPresenter(IDeleteItemView mDeleteItemView, Context mContext) {
        this.mDeleteItemView = mDeleteItemView;
        this.mDeleteModel = new DeleteTaskModel(this, mContext);
    }

    @Override
    public void delete(long id) {
        mDeleteModel.delete(id);
    }

    @Override
    public void onDeleted() {
        mDeleteItemView.onItemDeleted();
    }
}
