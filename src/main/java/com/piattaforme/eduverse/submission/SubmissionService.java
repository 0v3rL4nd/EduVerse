package com.piattaforme.eduverse.submission;

import com.piattaforme.eduverse.assignment.Assignment;
import com.piattaforme.eduverse.assignment.AssignmentRepository;
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

    public SubmissionResponseDto submit(SubmissionRequestDto dto) {
        User student = userRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Assignment assignment = assignmentRepo.findById(dto.getAssignmentId())
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
}
