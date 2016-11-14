package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.IReadSongModel;
import com.danielspeixoto.musician.model.ReadSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.view.ISongView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class ListSongPresenter implements IListSongPresenter,
        IReadSongPresenter {

    private ISongView mSongView;
    private IReadSongModel mReadSongModel;

    public ListSongPresenter(ISongView mSongView, Context mContext) {
        this.mSongView = mSongView;
        this.mReadSongModel = new ReadSongModel(this, mContext);
    }

    @Override
    public void getAll() {
        mReadSongModel.getAll();
    }

    @Override
    public void onSongReceived(Song song) {
        mSongView.addSong(song);
    }
}
