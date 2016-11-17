package com.danielspeixoto.musician.presenter.module;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IAllSongsPresenter{

    void selectAllSongs();

    void onReceivingSongs(Song song);

}
