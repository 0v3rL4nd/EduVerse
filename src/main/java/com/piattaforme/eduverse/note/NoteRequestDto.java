package com.piattaforme.eduverse.note;

import lombok.Data;

@Data
public class NoteRequestDto {
    private String title;
    private String content;
    private Long courseTitle;
}
