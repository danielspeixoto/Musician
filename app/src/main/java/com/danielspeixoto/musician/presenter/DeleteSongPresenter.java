package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.DeleteSongModel;
import com.danielspeixoto.musician.model.module.IDeleteModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IDeletePresenter;
import com.danielspeixoto.musician.view.module.IDeleteItemView;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public class DeleteSongPresenter implements IDeletePresenter<Song> {

    private final IDeleteItemView mDeleteItemView;
    private IDeleteModel mDeleteModel;

    public DeleteSongPresenter(IDeleteItemView mDeleteItemView, Context mContext) {
        this.mDeleteItemView = mDeleteItemView;
        this.mDeleteModel = new DeleteSongModel(this, mContext);
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
