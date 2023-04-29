package com.example.springbootandswagger.dto.modelsRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}