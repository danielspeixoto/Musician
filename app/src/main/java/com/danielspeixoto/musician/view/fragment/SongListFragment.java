package com.danielspeixoto.musician.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielspeixoto.musician.R;
import com.danielspeixoto.musician.view.activity.InsertSongActivity;
import com.danielspeixoto.musician.view.list.adapter.SongRecyclerAdapter;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class SongListFragment extends ListFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_list_fragment, container, false);
        ButterKnife.bind(this, view);
        mAdapter = new SongRecyclerAdapter((AppCompatActivity) getActivity());
        list = ButterKnife.findById(view, R.id.song_list);
        setUpList();
        return view;
    }

    @OnClick(R.id.newItem)
    public void newItem() {
        startActivity(new Intent(getActivity(), InsertSongActivity.class));
    }
}
