package com.piattaforme.eduverse.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}
