package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateSongModel;
import com.danielspeixoto.musician.model.module.IUpdateSongModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IUpdateSongPresenter;
import com.danielspeixoto.musician.view.module.IToastView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongPresenter implements IUpdateSongPresenter {

    private final IToastView mToastView;
    private IUpdateSongModel mUpdateSongModel;

    public UpdateSongPresenter(IToastView mToastView, Context mContext) {
        this.mToastView = mToastView;
        this.mUpdateSongModel = new UpdateSongModel(this, mContext);
    }

    @Override
    public void updateSong(Song song) {
        mUpdateSongModel.updateSong(song);
    }

    @Override
    public void onSongUpdated() {
        mToastView.showMessage("Song has been updated");
    }

}
