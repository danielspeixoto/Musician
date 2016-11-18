package com.danielspeixoto.musician.model.pojo;

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

    public Task(int id, String name, String description, ArrayList<ToDo> toDos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.toDos = toDos;
    }

    public void addTodo(ToDo toDo) {
        this.toDos.add(toDo);
    }

    public void removeTodo(int index) {
        this.toDos.remove(index);
    }
}
