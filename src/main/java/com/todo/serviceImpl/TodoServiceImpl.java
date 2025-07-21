package com.todo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entities.Todo;
import com.todo.repository.TodoRepo;
import com.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepo repo;

    @Override
    public List<Todo> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public void save(Todo task) {
        repo.save(task);
    }

    @Override
    public void toggleDone(int id) {
        Todo task = repo.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        repo.save(task);
    }

    @Override
    public void deleteTask(int id) {
        repo.deleteById(id);
    }
}
