package com.carmenoprinescu.task_service.repositories;

import com.carmenoprinescu.task_service.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);

    List<Task> findByStatus(boolean completed);

    List<Task> findByUserIdAndStatus(Long userId, boolean completed);
}
