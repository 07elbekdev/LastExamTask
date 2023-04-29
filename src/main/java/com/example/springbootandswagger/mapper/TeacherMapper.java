package com.example.springbootandswagger.mapper;

import com.example.springbootandswagger.dto.modelsRequest.TeacherRequest;
import com.example.springbootandswagger.model.Teacher;
import com.example.springbootandswagger.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public Teacher toTeacher(TeacherRequest teacherRequest) {
        return Teacher.builder()
                .firstName(teacherRequest.getFirstName())
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
    }
}