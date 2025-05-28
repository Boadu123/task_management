package com.ben.spring_boot.controllers;

import com.ben.spring_boot.models.TaskModels;
import com.ben.spring_boot.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskModels> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<TaskModels> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public TaskModels createTask(@RequestBody TaskModels task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Optional<TaskModels> updateTask(@PathVariable Long id, @RequestBody TaskModels task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}
