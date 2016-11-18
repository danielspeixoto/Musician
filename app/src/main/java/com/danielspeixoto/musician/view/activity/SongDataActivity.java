package com.danielspeixoto.musician.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class SongDataActivity extends BaseActivity {

    public static final String NO_TEXT = "";
    protected Song song = new Song();

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);
        ButterKnife.bind(this);
    }

    public void saveSong(View view) {
        song.setName(nameEdit.getText().toString());
        song.setArtist(artistEdit.getText().toString());
        song.setComments(commentsEdit.getText().toString());
        song.setLevel(levelSeek.getProgress());
        song.setBpm(bpmEdit.getText().toString().equals(NO_TEXT) ? 0 : Integer.getInteger((bpmEdit.getText().toString())));
        song.setBeatsPerBar(beatsPerBarEdit.getText().toString());
    }

}
