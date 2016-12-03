package com.danielspeixoto.musician.util;

import com.danielspeixoto.musician.model.pojo.Song;
import com.danielspeixoto.musician.model.pojo.Task;
import com.danielspeixoto.musician.model.pojo.ToDo;

/**
 * Created by danielspeixoto on 03/12/16.
 */
public class Auth {

    public static boolean verifyItem(Song song) {
        return song.getName().length() > 0;
    }

    public static boolean verifyItem(Task task) {
        return task.getName().length() > 0;
    }

    public static boolean verifyItem(ToDo toDo) {
        return toDo.getDescription().length() > 0;
    }
}
