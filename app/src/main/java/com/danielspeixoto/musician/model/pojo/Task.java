package com.danielspeixoto.musician.model.pojo;

import android.database.Cursor;

import com.danielspeixoto.musician.util.Contract;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by danielspeixoto on 13/11/16.
 */
@Data
public class Task extends Contract.TaskColumns {
    private int id;
    private String name;
    private String description;
    private ArrayList<ToDo> toDos;

    public Task() {
    }

    public Task(Cursor cursor) {
        id = cursor.getColumnIndex(_ID) != -1 ?
                cursor.getInt(cursor.getColumnIndex(_ID)) : 0;
        name = cursor.getColumnIndex(NAME) != -1 ?
                cursor.getString(cursor.getColumnIndex(NAME)) : null;
        description = cursor.getColumnIndex(DESCRIPTION) != -1 ?
                cursor.getString(cursor.getColumnIndex(DESCRIPTION)) : null;

    }

    public void addTodo(ToDo toDo) {
        this.toDos.add(toDo);
    }

}
