package com.danielspeixoto.musician.model.pojo;

import android.database.Cursor;

import com.danielspeixoto.musician.util.Contract;

import lombok.Data;

/**
 * Created by danielspeixoto on 13/11/16.
 */
@Data
public class Song extends Contract.SongColumns {

    private int id;
    private String name;
    private String artist;
    private String comments;
    private int level;
    private int bpm;
    private String beatsPerBar;

    public Song() {
    }

    public Song(Cursor cursor) {
        id = cursor.getColumnIndex(_ID) != -1 ?
                cursor.getInt(cursor.getColumnIndex(_ID)) : 0;
        name = cursor.getColumnIndex(NAME) != -1 ?
                cursor.getString(cursor.getColumnIndex(NAME)) : null;
        artist = cursor.getColumnIndex(ARTIST) != -1 ?
                cursor.getString(cursor.getColumnIndex(ARTIST)) : null;
        comments = cursor.getColumnIndex(COMMENTS) != -1 ?
                cursor.getString(cursor.getColumnIndex(COMMENTS)) : null;
        level = cursor.getColumnIndex(LEVEL) != -1 ?
                cursor.getInt(cursor.getColumnIndex(LEVEL)) : 0;
        bpm = cursor.getColumnIndex(BPM) != -1 ?
                cursor.getInt(cursor.getColumnIndex(BPM)) : 0;
        beatsPerBar = cursor.getColumnIndex(BEATS_PER_BAR) != -1 ?
                cursor.getString(cursor.getColumnIndex(BEATS_PER_BAR)) : null;

    }
}
