package com.ben.spring_boot.DTO;

import com.ben.spring_boot.models.TaskModels;

public class TaskMapper {

    public static TaskResponseDTO toDTO(TaskModels taskModels){
        return TaskResponseDTO.builder()
                .id(taskModels.getId())
                .title(taskModels.getTitle())
                .description(taskModels.getDescription())
                .completed(taskModels.isCompleted())
                .build();
    }

    public static TaskModels toModel(TaskRequestDTO taskRequestDTO){
        return TaskModels.builder()
                .title(taskRequestDTO.getTitle())
                .description(taskRequestDTO.getDescription())
                .completed(taskRequestDTO.getCompleted())
                .build();
    }
}
