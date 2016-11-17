package com.danielspeixoto.musician.view.module;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IListSongView extends IView{

    void addSongToList(Song song);

}
