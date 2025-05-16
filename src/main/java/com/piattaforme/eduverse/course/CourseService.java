package com.piattaforme.eduverse.course;

import org.springframework.stereotype.Service;
import com.piattaforme.eduverse.user.User;
import com.piattaforme.eduverse.user.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepo;
    private final UserRepository userRepo;

    public CourseResponseDto create(CourseRequestDto dto) {
        User instructor = userRepo.findById(dto.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .instructor(instructor)
                .build();

        courseRepo.save(course);
        return CourseResponseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .instructorName(instructor.getName())
                .build();
    }

    public List<CourseResponseDto> getAll() {
        return courseRepo.findAll().stream().map(c -> CourseResponseDto.builder()
                .id(c.getId())
                .title(c.getTitle())
                .description(c.getDescription())
                .instructorName(c.getInstructor().getName())
                .build()).toList();
    }
}
