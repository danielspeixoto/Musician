package com.danielspeixoto.musician.model.pojo;

import android.database.Cursor;

import com.danielspeixoto.musician.util.Contract;

import lombok.Data;

/**
 * Created by danielspeixoto on 13/11/16.
 */
@Data
public class ToDo extends Contract.ToDoColumns {
    private int id;
    private long taskId;
    private String description;
    private boolean isFinished;

    public ToDo(Cursor cursor) {
    }

    public ToDo(String description) {
        this.description = description;
    }
}
