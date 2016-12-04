package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.InsertToDoModel;
import com.danielspeixoto.musician.model.module.IInsertModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IInsertPresenter;
import com.danielspeixoto.musician.util.Auth;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 22/11/16.
 */
public class InsertToDoPresenter implements IInsertPresenter<ToDo> {

    private final IInsertView<ToDo> mInsertView;
    private final IInsertModel<ToDo> mInsertModel;
    private ToDo mTodo;

    public InsertToDoPresenter(IInsertView<ToDo> mInsertView, Context mContext) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertToDoModel(this, mContext);
    }

    @Override
    public void insert(ToDo toDo) {
        mTodo = toDo;
        if (Auth.verifyItem(toDo)) {
            mInsertModel.insert(toDo);
        } else {
            mInsertView.onErrorInserting("Must have at least one character");
        }
    }

    @Override
    public void onInserted(long id) {
        mTodo.setId(id);
        mInsertView.onObjectInserted(mTodo);
    }
}
