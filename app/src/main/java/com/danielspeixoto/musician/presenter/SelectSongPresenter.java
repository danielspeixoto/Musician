package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.SelectSongModel;
import com.danielspeixoto.musician.model.module.ISelectSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.ISelectSongPresenter;
import com.danielspeixoto.musician.view.module.ISelectSongView;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SelectSongPresenter implements ISelectSongPresenter {

    private ISelectSongView mSelectSongView;
    private ISelectSongModel mSelectSongModel;

    public SelectSongPresenter(ISelectSongView mSelectSongView, Context mContext) {
        this.mSelectSongView = mSelectSongView;
        this.mSelectSongModel = new SelectSongModel(this, mContext);

    }

    @Override
    public void selectSong(int id) {
        mSelectSongModel.selectSong(id);
    }

    @Override
    public void onSongReceived(Song song) {
        mSelectSongView.fillData(song);
    }
}
