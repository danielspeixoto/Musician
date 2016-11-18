package com.danielspeixoto.musician.model.pojo;

import com.danielspeixoto.musician.util.Contract;

import lombok.Data;

/**
 * Created by danielspeixoto on 13/11/16.
 */
@Data
public class ToDo extends Contract.ToDoColumns {
    private int id;
    private int taskId;
    private String description;
    private boolean isFinished;

    public ToDo(int id, int taskId, String description, boolean isFinished) {
        this.id = id;
        this.taskId = taskId;
        this.description = description;
        this.isFinished = isFinished;
    }
}
