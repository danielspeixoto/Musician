package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateSongModel;
import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.view.module.IToastView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongPresenter implements IUpdatePresenter<Song> {

    private final IToastView mToastView;
    private IUpdateModel mUpdateSongModel;

    public UpdateSongPresenter(IToastView mToastView, Context mContext) {
        this.mToastView = mToastView;
        this.mUpdateSongModel = new UpdateSongModel(this, mContext);
    }

    @Override
    public void update(Song song) {
        mUpdateSongModel.update(song);
    }

    @Override
    public void onUpdated() {
        mToastView.showMessage("Song has been updated");
    }

}
