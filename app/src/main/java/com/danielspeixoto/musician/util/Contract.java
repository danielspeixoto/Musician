package com.danielspeixoto.musician.util;

import android.provider.BaseColumns;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface Contract {

    class SongColumns implements BaseColumns {
        public static final String TABLE = "songs";
        public static final String NAME = "name";
        public static final String ARTIST = "artist";
        public static final String COMMENTS = "comments";
        public static final String LEVEL = "level";
        public static final String BPM = "bpm";
        public static final String BEATS_PER_BAR = "beatsPerBar";
        public static final String VIDEO_PATH = "videoPath";

    }

    class TaskColumns implements BaseColumns {
        public static final String TABLE = "tasks";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
    }

    class ToDoColumns implements BaseColumns {
        public static final String TABLE = "toDos";
        public static final String TASK_ID = "taskId";
        public static final String DESCRIPTION = "description";
        public static final String IS_FINISHED = "isFinished";
    }
}
