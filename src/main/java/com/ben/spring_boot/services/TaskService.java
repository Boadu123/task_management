package com.ben.spring_boot.services;

import com.ben.spring_boot.models.TaskModels;
import com.ben.spring_boot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModels> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModels> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskModels createTask(TaskModels taskModels){
        return taskRepository.save(taskModels);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    public Optional<TaskModels> updateTask(Long id, TaskModels update){
        Optional<TaskModels> savedTask = taskRepository.findById(id);

        if (savedTask.isPresent()) {
            TaskModels task = savedTask.get();

            task.setTitle(update.getTitle());
            task.setDescription(update.getDescription());
            task.setCompleted(update.isCompleted());

            TaskModels updatedTask = taskRepository.save(task);
            return Optional.of(updatedTask);
        } else {
            return Optional.empty();
        }
    }
}
