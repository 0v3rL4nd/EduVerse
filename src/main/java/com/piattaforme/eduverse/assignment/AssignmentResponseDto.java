package com.piattaforme.eduverse.assignment;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AssignmentResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String courseTitle;
}
