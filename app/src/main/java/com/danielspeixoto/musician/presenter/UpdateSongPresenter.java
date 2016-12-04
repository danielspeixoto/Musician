package com.danielspeixoto.musician.presenter;

import android.content.Context;

import com.danielspeixoto.musician.model.UpdateSongModel;
import com.danielspeixoto.musician.model.module.IUpdateModel;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.module.IUpdatePresenter;
import com.danielspeixoto.musician.util.Auth;
import com.danielspeixoto.musician.view.module.IUpdateView;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class UpdateSongPresenter implements IUpdatePresenter<Song> {

    private final IUpdateView mUpdateView;
    private final IUpdateModel mUpdateModel;

    public UpdateSongPresenter(IUpdateView mUpdateView, Context mContext) {
        this.mUpdateView = mUpdateView;
        this.mUpdateModel = new UpdateSongModel(this, mContext);
    }

    @Override
    public void update(Song song) {
        if (Auth.verifyItem(song)) {
            mUpdateModel.update(song);
        } else {
            mUpdateView.onErrorUpdating("Must have a name");
        }
    }

    @Override
    public void onUpdated() {
        mUpdateView.onObjectUpdated();
    }

}
