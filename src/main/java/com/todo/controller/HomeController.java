package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.entities.Todo;
import com.todo.service.TodoService;

@Controller
public class HomeController {

    @Autowired
    private TodoService taskService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "home";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String title) {
        Todo task = new Todo();
        task.setTitle(title);
        taskService.save(task);
        return "redirect:/";
    }

    @GetMapping("/done/{id}")
    public String markDone(@PathVariable int id) {
        taskService.toggleDone(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
