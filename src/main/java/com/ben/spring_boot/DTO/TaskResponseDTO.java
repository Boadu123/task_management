package com.ben.spring_boot.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {
    private int id;
    private String title;
    private String description;
    private boolean completed;
}
