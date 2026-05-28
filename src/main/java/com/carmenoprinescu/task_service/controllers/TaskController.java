package com.carmenoprinescu.task_service.controllers;

import com.carmenoprinescu.task_service.models.Task;
import com.carmenoprinescu.task_service.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/users/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @GetMapping("/completed/{completed}")
    public List<Task> getTasksByStatus(@PathVariable boolean completed) {
        return taskService.getTasksByStatus(completed);
    }

    @GetMapping("/users/{userId}/{completed}")
    public List<Task> getTasksByStatus(@PathVariable Long userId, @PathVariable boolean completed) {
        return taskService.getTasksByUserAndStatus(userId, completed);

    }

}