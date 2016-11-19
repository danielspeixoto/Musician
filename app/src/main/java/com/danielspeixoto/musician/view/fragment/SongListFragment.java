package com.danielspeixoto.musician.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.adapter.SongRecyclerAdapter;

import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SongListFragment extends BaseFragment {

    private SongRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_list_fragment, container, false);
        mAdapter = new SongRecyclerAdapter((AppCompatActivity) getActivity());
        RecyclerView songList = ButterKnife.findById(view, R.id.song_list);
        songList.setLayoutManager(new LinearLayoutManager(getContext()));
        songList.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.refreshData();
    }
}
