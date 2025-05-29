package com.ben.spring_boot.services;

import com.ben.spring_boot.DTO.TaskMapper;
import com.ben.spring_boot.DTO.TaskRequestDTO;
import com.ben.spring_boot.DTO.TaskResponseDTO;
import com.ben.spring_boot.exceptions.TaskNotFoundException;
import com.ben.spring_boot.models.TaskModels;
import com.ben.spring_boot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map((task) -> TaskMapper.toDTO(task))
                .toList();
    }

    public Optional<TaskResponseDTO> getTaskById(Long id) {
        Optional<TaskModels> optionalTaskModels = taskRepository.findById(id);

        if(!optionalTaskModels.isPresent()) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }

        return optionalTaskModels.map((task) -> TaskMapper.toDTO(task));
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO){
        TaskModels taskModel = TaskMapper.toModel(taskRequestDTO);
        TaskModels createdTask = taskRepository.save(taskModel);
        return TaskMapper.toDTO(createdTask);
    }

    public void deleteTaskById(Long id){
        if(!taskRepository.findById(id).isPresent()) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }

        taskRepository.deleteById(id);
    }

    public Optional<TaskResponseDTO> updateTask(Long id, TaskRequestDTO request) {
        Optional<TaskModels> existingTaskOpt = taskRepository.findById(id);

        if (existingTaskOpt.isEmpty()) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }

        TaskModels existingTask = existingTaskOpt.get();

        existingTask.setTitle(request.getTitle());
        existingTask.setDescription(request.getDescription());
        existingTask.setCompleted(request.getCompleted());

        TaskModels updatedTask = taskRepository.save(existingTask);

        return Optional.of(TaskMapper.toDTO(updatedTask));
    }

}
