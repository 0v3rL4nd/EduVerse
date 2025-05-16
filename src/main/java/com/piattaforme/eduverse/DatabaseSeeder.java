package com.piattaforme.eduverse;

import com.piattaforme.eduverse.assignment.Assignment;
import com.piattaforme.eduverse.assignment.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import com.piattaforme.eduverse.course.Course;
import com.piattaforme.eduverse.course.CourseRepository;
import com.piattaforme.eduverse.user.Role;
import com.piattaforme.eduverse.user.User;
import com.piattaforme.eduverse.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final AssignmentRepository assignmentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) return; // prevent duplicate seeds

        // Create Instructor
        User instructor = User.builder()
                .name("Dr. John Smith")
                .email("john@eduverse.com")
                .password(passwordEncoder.encode("john123"))
                .role(Role.INSTRUCTOR)
                .build();
        userRepository.save(instructor);

        // Create Student
        User student = User.builder()
                .name("Alice Johnson")
                .email("alice@student.com")
                .password(passwordEncoder.encode("alice123"))
                .role(Role.STUDENT)
                .build();
        userRepository.save(student);

        // Create Course
        Course course = Course.builder()
                .title("Spring Boot Mastery")
                .description("In-depth Spring Boot with security, JPA, and testing")
                .instructor(instructor)
                .build();
        courseRepository.save(course);

        // Create Assignment
        Assignment assignment = Assignment.builder()
                .title("Phase 1 Project Setup")
                .description("Create entities, security config, and Angular starter.")
                .dueDate(LocalDate.now().plusDays(10))
                .course(course)
                .build();
        assignmentRepository.save(assignment);

        System.out.println("✅ Seeded: Instructor, Student, Course, Assignment");
    }
}
