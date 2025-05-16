package com.piattaforme.eduverse.note;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NoteResponseDto {
    private Long id;
    private String title;
    private String content;
    private String studentName;
    private String courseTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
