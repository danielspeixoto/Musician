package com.danielspeixoto.musician.model;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IWriteSongModel {

    void insert(Song song);

    void update(Song song);

    void delete(Song song);
}
