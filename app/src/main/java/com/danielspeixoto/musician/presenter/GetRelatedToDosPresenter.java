package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.GetRelatedToDosModel;
import com.danielspeixoto.musician.model.module.IGetRelatedModel;
import com.danielspeixoto.musician.model.pojo.ToDo;
import com.danielspeixoto.musician.presenter.module.IGetRelatedPresenter;
import com.danielspeixoto.musician.view.module.IListView;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public class GetRelatedToDosPresenter implements IGetRelatedPresenter<ToDo> {

    private IListView<ToDo> mListToDoView;
    private IGetRelatedModel<ToDo> mGetRelatedModel;

    public GetRelatedToDosPresenter(IListView<ToDo> mListToDoView, Context mContext) {
        this.mListToDoView = mListToDoView;
        this.mGetRelatedModel = new GetRelatedToDosModel(this, mContext);
    }

    @Override
    public void onReceivingRelated(ToDo toDo) {
        mListToDoView.addItem(toDo);
    }

    @Override
    public void getRelated(int parentId) {
        mGetRelatedModel.getRelated(parentId);
    }

}