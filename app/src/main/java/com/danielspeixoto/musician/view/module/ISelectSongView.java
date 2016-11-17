package com.danielspeixoto.musician.view.module;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface ISelectSongView extends IView{

    void fillData(Song song);
}
