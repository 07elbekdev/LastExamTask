package com.example.springbootandswagger.dto.modelsResponse;

import com.example.springbootandswagger.model.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;
}
