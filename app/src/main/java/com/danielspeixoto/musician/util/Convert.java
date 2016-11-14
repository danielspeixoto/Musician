package com.danielspeixoto.musician.util;

import android.content.ContentValues;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by root on 14/11/16.
 */

public class Convert {

    public static ContentValues toContentValues(Song song) {
        ContentValues values = new ContentValues();
        values.put(Contract.SongColumns.NAME, song.getName());
        values.put(Contract.SongColumns.ARTIST, song.getArtist());
        values.put(Contract.SongColumns.COMMENTS, song.getComments());
        values.put(Contract.SongColumns.LEVEL, song.getLevel());
        values.put(Contract.SongColumns.BPM, song.getBpm());
        values.put(Contract.SongColumns.BEATS_PER_BAR, song.getBeatsPerBar());
        return values;
    }
}
