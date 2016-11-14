package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.EditSongPresenter;
import com.danielspeixoto.musician.presenter.IEditSongPresenter;
import com.danielspeixoto.musician.view.IEditSongView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class EditSongActivity extends BaseActivity implements IEditSongView {

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.artistEdit)
    EditText artistEdit;
    @BindView(R.id.bpmEdit)
    EditText bpmEdit;
    @BindView(R.id.beatsPerBarEdit)
    EditText beatsPerBarEdit;
    @BindView(R.id.commentsEdit)
    EditText commentsEdit;
    @BindView(R.id.levelSeek)
    SeekBar levelSeek;
    private IEditSongPresenter mEditSongPresenter;
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);
        ButterKnife.bind(this);
        mEditSongPresenter = new EditSongPresenter(this, this);
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
                bpmEdit.getText().toString().equals("") ? 0 : Integer.getInteger((bpmEdit.getText().toString())),
                beatsPerBarEdit.getText().toString());
        mEditSongPresenter.insertSong(song);
    }

}
