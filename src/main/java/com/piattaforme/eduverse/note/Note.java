package com.piattaforme.eduverse.note;

import com.piattaforme.eduverse.course.Course;
import com.piattaforme.eduverse.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "notes")
public class Note {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    private User student;

    @ManyToOne
    private Course course;
}
