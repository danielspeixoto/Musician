package com.danielspeixoto.musician.util;

import android.content.ContentValues;

import com.danielspeixoto.musician.model.pojo.Song;

/**
 * Created by root on 14/11/16.
 */

public class Convert {

    public static ContentValues toContentValues(Song song) {
        ContentValues values = new ContentValues();
        values.put(Song.NAME, song.getName());
        values.put(Song.ARTIST, song.getArtist());
        values.put(Song.COMMENTS, song.getComments());
        values.put(Song.LEVEL, song.getLevel());
        values.put(Song.BPM, song.getBpm());
        values.put(Song.BEATS_PER_BAR, song.getBeatsPerBar());
        values.put(Song.VIDEO_PATH, song.getVideoPath());
        return values;
    }
}
