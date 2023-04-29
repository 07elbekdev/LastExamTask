package com.example.springbootandswagger.dto.authReqeustAndRespoonse;

import com.example.springbootandswagger.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String email;
    private Role role;
    private String jwt;
}