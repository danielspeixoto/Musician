package com.danielspeixoto.musician.presenter;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 14/11/16.
 */
public interface IReadSongPresenter {

    void onSongReceived(Song song);

}
