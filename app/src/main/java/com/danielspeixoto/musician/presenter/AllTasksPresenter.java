package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.SelectAllTasksModel;
import com.danielspeixoto.musician.model.module.ISelectAllModel;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.presenter.module.ISelectAllPresenter;
import com.danielspeixoto.musician.view.module.IListView;

/**
 * Created by danielspeixoto on 21/11/16.
 */
public class AllTasksPresenter implements ISelectAllPresenter<Task> {

    private IListView<Task> mListView;
    private ISelectAllModel<Task> mSelectAllModel;

    public AllTasksPresenter(IListView mListView, Context mContext) {
        this.mListView = mListView;
        this.mSelectAllModel = new SelectAllTasksModel(this, mContext);
    }

    @Override
    public void selectAll() {
        mSelectAllModel.selectAll();
    }

    @Override
    public void onReceiving(Task task) {
        mListView.addItem(task);
    }

}
