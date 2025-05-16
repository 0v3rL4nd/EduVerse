package com.piattaforme.eduverse.course;

import lombok.Data;

@Data
class CourseRequestDto {
    private String title;
    private String description;
    private Long instructorId;
}
