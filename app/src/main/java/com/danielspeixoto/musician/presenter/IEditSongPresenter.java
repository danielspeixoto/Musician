package com.danielspeixoto.musician.presenter;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IEditSongPresenter {

    void getRow(int index);

    void insertSong(Song song);

    void updateSong(Song song);

}
