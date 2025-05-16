package com.piattaforme.eduverse.assignment;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignmentRequestDto {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long courseId;
}
