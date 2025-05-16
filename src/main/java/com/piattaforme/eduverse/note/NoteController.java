package com.piattaforme.eduverse.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<NoteResponseDto> create(
            @RequestBody NoteRequestDto dto,
            Authentication authentication) {

        String email = authentication.getName(); // email from token
        return ResponseEntity.ok(noteService.createForLoggedUser(dto, email));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<NoteResponseDto>> getAllByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getAllByStudent(id));
    }
}

