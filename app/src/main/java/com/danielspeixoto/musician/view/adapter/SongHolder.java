package com.danielspeixoto.musician.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.danielspeixoto.musician.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public class SongHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.songName)
    TextView songName;
    @BindView(R.id.songArtist)
    TextView songArtist;

    public SongHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
