package com.todo.service;

import java.util.List;

import com.todo.entities.Todo;

public interface TodoService {
	
	public List<Todo> getAllTasks();

    public void save(Todo task);

    public void toggleDone(int id);

    public void deleteTask(int id);

}
