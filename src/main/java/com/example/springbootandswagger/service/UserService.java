package com.example.springbootandswagger.service;

import com.example.springbootandswagger.dto.modelsRequest.UserRequest;
import com.example.springbootandswagger.dto.modelsResponse.UserResponse;
import com.example.springbootandswagger.mapper.UserMapper;
import com.example.springbootandswagger.model.User;
import com.example.springbootandswagger.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;

    public UserResponse registerUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("This email is already have in!");
        }
        User savedUser = userRepository.save(userMapper.toUser(userRequest));
        return modelMapper.map(savedUser, UserResponse.class);
    }
}