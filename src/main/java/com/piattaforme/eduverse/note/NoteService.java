package com.piattaforme.eduverse.note;

import com.piattaforme.eduverse.course.Course;
import com.piattaforme.eduverse.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.piattaforme.eduverse.user.User;
import com.piattaforme.eduverse.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepo;
    private final CourseRepository courseRepo;
    private final UserRepository userRepo;

    public NoteResponseDto createForLoggedUser(NoteRequestDto dto, String email) {
        User student = userRepo.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = courseRepo.findByTitleIgnoreCase(String.valueOf(dto.getCourseTitle()))
                .orElseThrow(() -> new RuntimeException("Course not found with title: " + dto.getCourseTitle()));

        Note note = Note.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .student(student)
                .course(course)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        noteRepo.save(note);
        return mapToDto(note);
    }



    public List<NoteResponseDto> getAllByStudent(Long studentId) {
        return noteRepo.findByStudentId(studentId).stream()
                .map(this::mapToDto).toList();
    }

    private NoteResponseDto mapToDto(Note note) {
        return NoteResponseDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .courseTitle(note.getCourse().getTitle())
                .studentName(note.getStudent().getName())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }
}
