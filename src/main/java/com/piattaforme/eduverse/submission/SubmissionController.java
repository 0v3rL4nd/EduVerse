package com.piattaforme.eduverse.submission;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService service;

    @PostMapping
    public ResponseEntity<SubmissionResponseDto> submit(@RequestBody SubmissionRequestDto dto) {
        return ResponseEntity.ok(service.submit(dto));
    }

    @GetMapping
    public ResponseEntity<List<SubmissionResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
