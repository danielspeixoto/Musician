package com.danielspeixoto.musician.model.pojo;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public class Task {
    private final int id;
    private String name;
    private String description;
    private ArrayList<Todo> todos;

    public Task(int id, String name, String description, ArrayList<Todo> todos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.todos = todos;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }

    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    public void addTodo(Todo todo) {
        this.todos.add(todo);
    }

    public void removeTodo(int index) {
        this.todos.remove(index);
    }
}
