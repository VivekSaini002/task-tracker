package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entities.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer>{
	

}
