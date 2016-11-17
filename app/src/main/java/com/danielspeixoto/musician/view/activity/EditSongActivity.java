package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.InsertSongPresenter;
import com.danielspeixoto.musician.presenter.SelectSongPresenter;
import com.danielspeixoto.musician.presenter.UpdateSongPresenter;
import com.danielspeixoto.musician.util.Contract;
import com.danielspeixoto.musician.view.module.ISelectSongView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class EditSongActivity extends BaseActivity implements ISelectSongView, Contract {

    @BindView(R.id.nameEdit) EditText nameEdit;
    @BindView(R.id.artistEdit) EditText artistEdit;
    @BindView(R.id.bpmEdit) EditText bpmEdit;
    @BindView(R.id.beatsPerBarEdit) EditText beatsPerBarEdit;
    @BindView(R.id.commentsEdit) EditText commentsEdit;
    @BindView(R.id.levelSeek) SeekBar levelSeek;

    private int id;
    public static final int NO_ID = -1;
    public static final String NO_TEXT = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);
        ButterKnife.bind(this);
        id = getIntent().getIntExtra(SongColumns._ID, NO_ID);
        if(id != NO_ID) {
            new SelectSongPresenter(this, this).selectSong(id);
        }
    }

    @Override
    public void fillData(Song song) {
        nameEdit.setText(song.getName());
        artistEdit.setText(song.getArtist());
        bpmEdit.setText(song.getBpm());
        beatsPerBarEdit.setText(song.getBeatsPerBar());
        commentsEdit.setText(song.getComments());
        levelSeek.setProgress(song.getLevel());
    }

    public void saveSong(View view) {
        Song song = new Song(nameEdit.getText().toString(),
                artistEdit.getText().toString(),
                commentsEdit.getText().toString(),
                levelSeek.getProgress(),
                // TODO check if it is really a number
                bpmEdit.getText().toString().equals(NO_TEXT) ? 0 : Integer.getInteger((bpmEdit.getText().toString())),
                beatsPerBarEdit.getText().toString());
        if(id != NO_ID) {
            new UpdateSongPresenter(this).updateSong(song);
        } else {
            new InsertSongPresenter(this).insertSong(song);
        }
    }

}
