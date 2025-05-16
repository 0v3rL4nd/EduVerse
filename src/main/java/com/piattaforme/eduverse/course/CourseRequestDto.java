package com.piattaforme.eduverse.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class CourseResponseDto {
    private Long id;
    private String title;
    private String description;
    private String instructorName;
}
