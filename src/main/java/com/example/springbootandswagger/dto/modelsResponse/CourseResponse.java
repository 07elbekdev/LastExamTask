package com.example.springbootandswagger.dto.modelsResponse;

import lombok.Data;

@Data
public class CourseResponse {

    private Long courseId;
    private String courseName;
    private String duration;
}
