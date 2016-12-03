package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateToDoModel;
import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.util.Auth;
import com.danielspeixoto.musician.view.module.IUpdateView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class UpdateToDoPresenter implements IUpdatePresenter<ToDo> {

    private final IUpdateView mUpdateView;
    private final IUpdateModel mUpdateModel;

    public UpdateToDoPresenter(IUpdateView mUpdateView, Context context) {
        this.mUpdateView = mUpdateView;
        this.mUpdateModel = new UpdateToDoModel(this, context);
    }

    @Override
    public void update(ToDo toDo) {
        if (Auth.verifyItem(toDo)) {
            mUpdateModel.update(toDo);
        }
    }

    @Override
    public void onUpdated() {
        mUpdateView.onObjectUpdated();
    }
}
