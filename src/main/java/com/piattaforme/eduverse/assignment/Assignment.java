package com.piattaforme.eduverse.assignment;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import com.piattaforme.eduverse.course.Course;
import com.piattaforme.eduverse.submission.Submission;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "assignments")
public class Assignment {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "assignment")
    private List<Submission> submissions;
}
