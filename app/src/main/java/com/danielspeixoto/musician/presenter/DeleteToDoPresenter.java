package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.DeleteToDoModel;
import com.danielspeixoto.musician.model.module.IDeleteModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IDeletePresenter;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 03/12/16.
 */
public class DeleteToDoPresenter implements IDeletePresenter<ToDo> {

    private final IDeleteItemView mDeleteItemView;
    private IDeleteModel mDeleteModel;

    public DeleteToDoPresenter(IDeleteItemView mDeleteItemView, Context mContext) {
        this.mDeleteItemView = mDeleteItemView;
        this.mDeleteModel = new DeleteToDoModel(this, mContext);
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