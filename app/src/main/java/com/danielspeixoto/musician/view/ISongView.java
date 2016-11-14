package com.danielspeixoto.musician.view;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface ISongView {

    void showMessage(String message);

    void addSong(Song song);

    void removeSong(int index);
}
