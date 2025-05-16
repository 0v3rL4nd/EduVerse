package com.piattaforme.eduverse.course;

import com.piattaforme.eduverse.assignment.Assignment;
import com.piattaforme.eduverse.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "courses")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private User instructor;

    @OneToMany(mappedBy = "course")
    private List<Assignment> assignments;
}
