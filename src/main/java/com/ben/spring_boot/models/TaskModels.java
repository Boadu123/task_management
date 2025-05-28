package com.ben.spring_boot.models;

import jakarta.persistence.*;
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

    private String title;
    private String description;
    private boolean completed;
}
