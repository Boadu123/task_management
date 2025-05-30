package com.ben.spring_boot.DTO;

public class TaskResponseDTO {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    // No-args Constructor
    public TaskResponseDTO() {
    }

    // All-args Constructor
    public TaskResponseDTO(int id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    // Builder Class
    public static class Builder {
        private int id;
        private String title;
        private String description;
        private boolean completed;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder completed(boolean completed) {
            this.completed = completed;
            return this;
        }

        public TaskResponseDTO build() {
            return new TaskResponseDTO(id, title, description, completed);
        }
    }
}