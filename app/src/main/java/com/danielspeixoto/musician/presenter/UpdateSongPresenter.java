package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateSongModel;
import com.danielspeixoto.musician.model.module.IUpdateSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IUpdateSongPresenter;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongPresenter implements IUpdateSongPresenter {

    private IUpdateSongModel mUpdateSongModel;

    public UpdateSongPresenter(Context mContext) {
        this.mUpdateSongModel = new UpdateSongModel(this, mContext);

    }

    @Override
    public void updateSong(Song song) {
        mUpdateSongModel.updateSong(song);
    }
    
}
