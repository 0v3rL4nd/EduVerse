package com.piattaforme.eduverse.submission;

import lombok.Data;

@Data
public class SubmissionRequestDto {
    private Long assignmentId;
    private Long studentId;
    private String fileUrl;
}
