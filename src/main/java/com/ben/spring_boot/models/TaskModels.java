package com.ben.spring_boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "task_management")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private boolean completed;
}
