package com.piattaforme.eduverse.submission;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService service;

    @PostMapping
    public ResponseEntity<SubmissionResponseDto> submit(
            @RequestBody SubmissionRequestDto dto,
            Authentication authentication) {

        String email = authentication.getName(); // from JWT
        return ResponseEntity.ok(service.submitForLoggedUser(dto, email));
    }

    @GetMapping
    public ResponseEntity<List<SubmissionResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}/grade")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<?> gradeSubmission(@PathVariable Long id, @RequestBody GradeRequest request) {
        return ResponseEntity.ok(service.gradeSubmission(id, request.getGrade()));
    }

    @GetMapping("/assignment/{title}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<List<SubmissionResponseDto>> getByAssignmentTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.getSubmissionsByAssignmentTitle(title));
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<List<SubmissionResponseDto>> getMySubmissions(Authentication auth) {
        return ResponseEntity.ok(service.getSubmissionsForStudent(auth.getName()));
    }

}
