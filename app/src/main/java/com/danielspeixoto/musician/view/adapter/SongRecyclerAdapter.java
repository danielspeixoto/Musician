package com.danielspeixoto.musician.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 14/11/16.
 */
public class SongRecyclerAdapter extends BaseRecyclerAdapter {

    public SongRecyclerAdapter(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_song_item, parent, false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Song song = (Song) mData.get(position);
        SongHolder songHolder = (SongHolder) holder;
        songHolder.songName.setText(song.getName());
        songHolder.songArtist.setText(song.getArtist());
    }

}
