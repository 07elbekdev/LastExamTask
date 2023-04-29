package com.example.springbootandswagger.api;

import com.example.springbootandswagger.dto.modelsRequest.CourseRequest;
import com.example.springbootandswagger.dto.modelsResponse.CourseResponse;
import com.example.springbootandswagger.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CourseApi {

    private final CourseService courseService;

    @PostMapping("/create/course")
    public String createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.createCourse(courseRequest);
        return "Course successfully created!";
    }

    @GetMapping("/get/All/courses")
    public List<CourseResponse> getAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/get/courseBy/{id}")
    public CourseResponse getById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @DeleteMapping("/delete/courseBy/{id}")
    public String deleteById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "Course successfully deleted!";
    }

    @PutMapping("/update/courseBy/{id}")
    public String updateById(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourseById(id, courseRequest);
        return "Course successfully updated!";
    }
}