package com.example.springbootandswagger.api;

import com.example.springbootandswagger.dto.authReqeustAndRespoonse.AuthRequest;
import com.example.springbootandswagger.dto.authReqeustAndRespoonse.AuthResponse;
import com.example.springbootandswagger.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/login")
    @PermitAll
    public AuthResponse authenticated(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}