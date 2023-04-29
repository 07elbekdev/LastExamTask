package com.example.springbootandswagger.service;

import com.example.springbootandswagger.dto.modelsRequest.TeacherRequest;
import com.example.springbootandswagger.dto.modelsResponse.TeacherResponse;
import com.example.springbootandswagger.exception.CustomRuntimeException;
import com.example.springbootandswagger.mapper.TeacherMapper;
import com.example.springbootandswagger.mapper.UserMapper;
import com.example.springbootandswagger.model.Teacher;
import com.example.springbootandswagger.repository.TeacherRepository;
import com.example.springbootandswagger.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final TeacherMapper teacherMapper;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;

    public TeacherResponse registerTeacher(TeacherRequest teacherRequest) {
        if (teacherRepository.existsByEmail(teacherRequest.getEmail())) {
            throw new RuntimeException(
                    "This email is already have in!"
            );
        }
        userRepository.save(userMapper.toUser(teacherRequest));
        Teacher savedTeacher = teacherRepository.save(teacherMapper.toTeacher(teacherRequest));
        return modelMapper.map(savedTeacher, TeacherResponse.class);
    }

    public TeacherResponse findTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Teacher with id: " + id+ " not found"));
        return modelMapper.map(teacher, TeacherResponse.class);
    }

    public List<TeacherResponse> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(teacher -> modelMapper.map(teacher, TeacherResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteTeacherById(Long id) {
        boolean exists = teacherRepository.existsById(id);
        if (!exists) {
            throw new CustomRuntimeException("Teacher with id : " + id + "doesn't exist.");
        }
        teacherRepository.deleteById(id);
    }

    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Teacher not found with id " + id));
        modelMapper.map(teacherRequest, teacher);
        teacher = teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherResponse.class);
    }
}