package com.example.springbootandswagger.service;

import com.example.springbootandswagger.config.JwtUtils;
import com.example.springbootandswagger.dto.authReqeustAndRespoonse.AuthRequest;
import com.example.springbootandswagger.dto.authReqeustAndRespoonse.AuthResponse;
import com.example.springbootandswagger.model.Role;
import com.example.springbootandswagger.model.User;
import com.example.springbootandswagger.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {

        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));
        Optional<User> user = userRepository.findByEmail(authRequest.getEmail());
        Role role = user.get().getRole();
        if (!BCrypt.checkpw(authRequest.getPassword(), user.get().getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }
        String generatedToken = jwtUtils.generateToken(authentication);
        System.out.println(generatedToken);
        return new AuthResponse(authRequest.getEmail(), role, generatedToken);
    }
}