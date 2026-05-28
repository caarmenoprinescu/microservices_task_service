package com.carmenoprinescu.task_service.services;

import com.carmenoprinescu.task_service.dtos.UserDto;
import com.carmenoprinescu.task_service.models.Task;
import com.carmenoprinescu.task_service.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TaskService {

    private final TaskRepository taskRepository;
    private final RestClient restClient;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {

        UserDto user = restClient.get()

                .uri("/users/{id}", task.getUserId())
                .retrieve()
                .body(UserDto.class);

        System.out.println("USER SERVICE CALLED -> " + user);

        return taskRepository.save(task);

    }

    public Task getTaskById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }


    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByStatus(completed);
    }

    public List<Task> getTasksByUserAndStatus(Long userId, boolean completed) {
        return taskRepository.findByUserIdAndStatus(userId, completed);
    }
}