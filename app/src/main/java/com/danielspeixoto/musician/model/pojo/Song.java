package com.danielspeixoto.musician.model.pojo;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class Song implements Comparable<Song>{

    private int id;
    private String name;
    private String artist;
    private String comments;
    private int level;
    private int bpm;
    private String beatsPerBar;

    public Song(int id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public Song(int id,
                String name,
                String artist,
                String comments,
                int level,
                int bpm,
                String beatsPerBar) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.comments = comments;
        this.level = level;
        this.bpm = bpm;
        this.beatsPerBar = beatsPerBar;
    }

    public Song(String name,
                String artist,
                String comments,
                int level,
                int bpm,
                String beatsPerBar) {
        this.name = name;
        this.artist = artist;
        this.comments = comments;
        this.level = level;
        this.bpm = bpm;
        this.beatsPerBar = beatsPerBar;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public String getBeatsPerBar() {
        return beatsPerBar;
    }

    public void setBeatsPerBar(String beatsPerBar) {
        this.beatsPerBar = beatsPerBar;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getArtist();
    }

    @Override
    public int compareTo(Song song) {
        return getName().compareTo(song.getName());
    }
}
