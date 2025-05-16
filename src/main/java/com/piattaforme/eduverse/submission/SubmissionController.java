package com.piattaforme.eduverse.submission;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
