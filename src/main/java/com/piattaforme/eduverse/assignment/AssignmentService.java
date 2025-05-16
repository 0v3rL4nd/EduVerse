package com.piattaforme.eduverse.assignment;

import com.piattaforme.eduverse.course.Course;
import org.springframework.stereotype.Service;
import com.piattaforme.eduverse.course.CourseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepo;
    private final CourseRepository courseRepo;

    public AssignmentResponseDto create(AssignmentRequestDto dto) {
        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Assignment assignment = Assignment.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .dueDate(dto.getDueDate())
                .course(course)
                .build();

        assignmentRepo.save(assignment);
        return AssignmentResponseDto.builder()
                .id(assignment.getId())
                .title(assignment.getTitle())
                .description(assignment.getDescription())
                .dueDate(assignment.getDueDate())
                .courseTitle(course.getTitle())
                .build();
    }

    public List<AssignmentResponseDto> getAll() {
        return assignmentRepo.findAll().stream()
                .map(a -> AssignmentResponseDto.builder()
                        .id(a.getId())
                        .title(a.getTitle())
                        .description(a.getDescription())
                        .dueDate(a.getDueDate())
                        .courseTitle(a.getCourse().getTitle())
                        .build())
                .toList();
    }
}
