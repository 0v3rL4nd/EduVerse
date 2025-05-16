package com.piattaforme.eduverse.submission;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubmissionResponseDto {
    private Long id;
    private String studentName;
    private String assignmentTitle;
    private String fileUrl;
    private Double grade;
}
