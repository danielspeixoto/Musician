package com.danielspeixoto.musician.view.activity;

import android.view.View;
import android.widget.Toast;

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
        finish();
    }

    @Override
    public void onObjectInserted(Song song) {
        Toast.makeText(getApplicationContext(), "Song has been created", Toast.LENGTH_LONG).show();
    }
}
