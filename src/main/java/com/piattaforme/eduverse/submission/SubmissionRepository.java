package com.piattaforme.eduverse.submission;

import com.piattaforme.eduverse.assignment.Assignment;
import com.piattaforme.eduverse.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByAssignment(Assignment assignment);
    List<Submission> findByStudent(User student);
}