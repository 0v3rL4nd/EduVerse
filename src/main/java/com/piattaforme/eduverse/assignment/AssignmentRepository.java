package com.piattaforme.eduverse.assignment;

import com.piattaforme.eduverse.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findByTitleIgnoreCaseAndCourse(String title, Course course);

}