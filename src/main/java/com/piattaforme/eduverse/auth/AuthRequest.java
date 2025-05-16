package com.piattaforme.eduverse.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
