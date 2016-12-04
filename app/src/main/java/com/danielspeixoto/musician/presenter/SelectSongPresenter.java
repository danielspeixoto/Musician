package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.SelectSongModel;
import com.danielspeixoto.musician.model.module.ISelectModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectPresenter;
import com.danielspeixoto.musician.view.module.ISelectView;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SelectSongPresenter implements ISelectPresenter<Song> {

    private final ISelectView mSelectView;
    private final ISelectModel mSelectSongModel;

    public SelectSongPresenter(ISelectView mSelectSongView, Context mContext) {
        this.mSelectView = mSelectSongView;
        this.mSelectSongModel = new SelectSongModel(this, mContext);
    }

    @Override
    public void select(long id) {
        mSelectSongModel.select(id);
    }

    @Override
    public void onReceived(Song song) {
        mSelectView.fillData(song);
    }
}
