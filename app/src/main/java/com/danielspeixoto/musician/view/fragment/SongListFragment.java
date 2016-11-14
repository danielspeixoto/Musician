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
import com.danielspeixoto.musician.presenter.IListSongPresenter;
import com.danielspeixoto.musician.presenter.ListSongPresenter;
import com.danielspeixoto.musician.view.ISongView;
import com.danielspeixoto.musician.view.adapter.RecyclerAdapter;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SongListFragment extends BaseFragment implements ISongView {

    private IListSongPresenter mSongPresenter;
    private RecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_list_fragment, container, false);

        mSongPresenter = new ListSongPresenter(this, getContext());

        RecyclerView songList = (RecyclerView) view.findViewById(R.id.song_list);
        mAdapter = new RecyclerAdapter(getActivity());
        songList.setAdapter(mAdapter);
        songList.setLayoutManager(new LinearLayoutManager(getContext()));
        songList.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mSongPresenter.getAll();
            }
        }).start();
    }

    @Override
    public void addSong(Song song) {
        mAdapter.addSong(song);
        updateList();
    }

    @Override
    public void removeSong(int index) {
        mAdapter.removeSong(index);
        updateList();
    }

    private void updateList() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
