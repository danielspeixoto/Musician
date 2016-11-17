package com.danielspeixoto.musician.presenter.module;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface ISelectSongPresenter {

    void selectSong(int id);

    void onSongReceived(Song song);

}
