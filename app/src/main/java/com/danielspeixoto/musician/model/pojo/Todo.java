package com.danielspeixoto.musician.model.pojo;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class Todo {
    private final int id;
    private final int taskId;
    private String description;
    private boolean isFinished;

    public Todo(int id, int taskId, String description, boolean isFinished) {
        this.id = id;
        this.taskId = taskId;
        this.description = description;
        this.isFinished = isFinished;
    }

    public int getId() {
        return id;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
