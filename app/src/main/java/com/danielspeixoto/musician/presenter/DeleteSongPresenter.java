package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.DeleteSongModel;
import com.danielspeixoto.musician.model.module.IDeleteSongModel;
import com.danielspeixoto.musician.presenter.module.IDeleteSongPresenter;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class DeleteSongPresenter implements IDeleteSongPresenter {

    private final IDeleteItemView mDeleteItemView;
    private IDeleteSongModel mDeleteSongModel;

    public DeleteSongPresenter(IDeleteItemView mDeleteItemView, Context mContext) {
        this.mDeleteItemView = mDeleteItemView;
        this.mDeleteSongModel = new DeleteSongModel(this, mContext);
    }

    @Override
    public void deleteSong(int id) {
        mDeleteSongModel.deleteSong(id);
    }

    @Override
    public void onSongDeleted() {
        mDeleteItemView.refreshData();
    }
}
