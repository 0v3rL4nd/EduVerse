package com.piattaforme.eduverse.submission;

import com.piattaforme.eduverse.assignment.Assignment;
import com.piattaforme.eduverse.assignment.AssignmentRepository;
import com.piattaforme.eduverse.course.Course;
import com.piattaforme.eduverse.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.piattaforme.eduverse.user.User;
import com.piattaforme.eduverse.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepo;
    private final AssignmentRepository assignmentRepo;
    private final UserRepository userRepo;
    private final CourseRepository courseRepo;

    public SubmissionResponseDto submitForLoggedUser(SubmissionRequestDto dto, String email) {
        User student = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findByTitleIgnoreCase(dto.getCourseTitle())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Assignment assignment = assignmentRepo.findByTitleIgnoreCaseAndCourse(dto.getAssignmentTitle(), course)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        Submission submission = Submission.builder()
                .fileUrl(dto.getFileUrl())
                .assignment(assignment)
                .student(student)
                .build();

        submissionRepo.save(submission);
        return mapToDto(submission);
    }


    public List<SubmissionResponseDto> getAll() {
        return submissionRepo.findAll().stream().map(this::mapToDto).toList();
    }

    private SubmissionResponseDto mapToDto(Submission sub) {
        return SubmissionResponseDto.builder()
                .id(sub.getId())
                .studentName(sub.getStudent().getName())
                .assignmentTitle(sub.getAssignment().getTitle())
                .fileUrl(sub.getFileUrl())
                .grade(sub.getGrade())
                .build();
    }

    public SubmissionResponseDto gradeSubmission(Long id, Double grade) {
        Submission submission = submissionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        submission.setGrade(grade);
        submissionRepo.save(submission);
        return mapToDto(submission);
    }

    public List<SubmissionResponseDto> getSubmissionsByAssignmentTitle(String title) {
        Assignment assignment = assignmentRepo.findByTitleIgnoreCase(title)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        return submissionRepo.findByAssignment(assignment).stream().map(this::mapToDto).toList();
    }

    public List<SubmissionResponseDto> getSubmissionsForStudent(String email) {
        User student = userRepo.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return submissionRepo.findByStudent(student).stream().map(this::mapToDto).toList();
    }

}
