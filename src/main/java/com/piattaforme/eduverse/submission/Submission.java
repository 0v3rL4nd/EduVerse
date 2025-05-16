package com.piattaforme.eduverse.submission;

import com.piattaforme.eduverse.assignment.Assignment;
import com.piattaforme.eduverse.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {

    @Id @GeneratedValue
    private Long id;

    private String fileUrl;
    private Double grade;

    @ManyToOne
    private Assignment assignment;

    @ManyToOne
    private User student;
}
