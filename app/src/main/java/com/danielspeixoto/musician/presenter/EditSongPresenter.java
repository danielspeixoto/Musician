package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.IReadSongModel;
import com.danielspeixoto.musician.model.IWriteSongModel;
import com.danielspeixoto.musician.model.ReadSongModel;
import com.danielspeixoto.musician.model.WriteSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.view.IEditSongView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class EditSongPresenter implements IEditSongPresenter,
        IWriteSongPresenter, IReadSongPresenter {

    private IEditSongView mEditSongView;
    private IWriteSongModel mWriteSongModel;
    private IReadSongModel mReadSongModel;


    public EditSongPresenter(IEditSongView mEditSongView, Context mContext) {
        this.mEditSongView = mEditSongView;
        this.mWriteSongModel = new WriteSongModel(this, mContext);
        this.mReadSongModel = new ReadSongModel(this, mContext);

    }

    @Override
    public void getRow(int index) {
        mReadSongModel.getRow(index);
    }

    @Override
    public void insertSong(Song song) {
        mWriteSongModel.insert(song);
    }

    @Override
    public void updateSong(Song song) {
        mWriteSongModel.update(song);
    }

    @Override
    public void onSongReceived(Song song) {
        mEditSongView.fillData(song);
    }

}
