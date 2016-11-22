package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateToDoModel;
import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.view.module.IToastView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class UpdateToDoPresenter implements IUpdatePresenter<ToDo> {

    private final IToastView mToastView;
    private final IUpdateModel mUpdateModel;

    public UpdateToDoPresenter(IToastView mToastView, Context context) {
        this.mToastView = mToastView;
        this.mUpdateModel = new UpdateToDoModel(this, context);
    }

    @Override
    public void update(ToDo toDo) {
        mUpdateModel.update(toDo);
    }

    @Override
    public void onUpdated() {

    }
}
