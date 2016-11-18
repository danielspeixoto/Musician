package com.danielspeixoto.musician.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.presenter.AllSongsPresenter;
import com.danielspeixoto.musician.presenter.module.IAllSongsPresenter;
import com.danielspeixoto.musician.view.adapter.SongRecyclerAdapter;
import com.danielspeixoto.musician.view.module.IListSongView;
/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SongListFragment extends BaseFragment implements IListSongView {

    private IAllSongsPresenter mAllSongsPresenter;
    private SongRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_list_fragment, container, false);

        mAllSongsPresenter = new AllSongsPresenter(this, getContext());

        RecyclerView songList = (RecyclerView) view.findViewById(R.id.song_list);
        mAdapter = new SongRecyclerAdapter(getActivity());
        songList.setAdapter(mAdapter);
        songList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.removeAll();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mAllSongsPresenter.selectAllSongs();
            }
        }).start();
    }

    @Override
    public void addSongToList(Song song) {
        mAdapter.addItem(song);
    }
}
