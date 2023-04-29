package com.example.springbootandswagger.mapper;

import com.example.springbootandswagger.dto.modelsRequest.StudentRequest;
import com.example.springbootandswagger.dto.modelsRequest.TeacherRequest;
import com.example.springbootandswagger.dto.modelsRequest.UserRequest;
import com.example.springbootandswagger.model.Role;
import com.example.springbootandswagger.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .firstName((userRequest.getFirstName()))
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .build();
    }

    public User toUser(StudentRequest studentRequest) {
        return User.builder()
                .firstName((studentRequest.getFirstName()))
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(studentRequest.getPassword()))
                .role(Role.STUDENT)
                .build();
    }

    public User toUser(TeacherRequest teacherRequest) {
        return User.builder()
                .firstName((teacherRequest.getFirstName()))
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
    }
}