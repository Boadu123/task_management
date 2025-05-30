package com.ben.spring_boot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Completed status (true or false) must be provided")
    private Boolean completed;

    // No-args Constructor
    public TaskRequestDTO() {
    }

    // All-args Constructor
    public TaskRequestDTO(String title, String description, Boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    // Builder Class
    public static class Builder {
        private String title;
        private String description;
        private Boolean completed;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder completed(Boolean completed) {
            this.completed = completed;
            return this;
        }

        public TaskRequestDTO build() {
            return new TaskRequestDTO(title, description, completed);
        }
    }
}