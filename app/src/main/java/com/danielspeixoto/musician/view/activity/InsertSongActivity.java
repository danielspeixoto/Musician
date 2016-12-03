package com.danielspeixoto.musician.view.activity;

import android.view.View;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.InsertSongPresenter;
import com.danielspeixoto.musician.view.module.IInsertView;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class InsertSongActivity extends SongDataActivity implements IInsertView<Song> {

    @Override
    public void saveSong(View view) {
        super.saveSong(view);
        new InsertSongPresenter(this, this).insert(song);
    }

    @Override
    public void onObjectInserted(Song song) {
        showMessage("Song has been created");
        finish();
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }
}
