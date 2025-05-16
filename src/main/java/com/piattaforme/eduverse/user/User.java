package com.piattaforme.eduverse.user;

import com.piattaforme.eduverse.course.Course;
import jakarta.persistence.*;
import lombok.*;
import com.piattaforme.eduverse.note.Note;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    @OneToMany(mappedBy = "student")
    private List<Note> notes;
}
