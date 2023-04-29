package com.example.springbootandswagger.api;

import com.example.springbootandswagger.dto.modelsRequest.TeacherRequest;
import com.example.springbootandswagger.dto.modelsResponse.TeacherResponse;
import com.example.springbootandswagger.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherApi {

    private final TeacherService teacherService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save/teacher")
    public String saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        teacherService.registerTeacher(teacherRequest);
        return "Teacher was successfully saved!";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @GetMapping("/get/all/teachers")
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @GetMapping("/get/teacherBy/{id}")
    public TeacherResponse getById(@PathVariable Long id) {
        return teacherService.findTeacherById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @DeleteMapping("/delete/teacherBy/{id}")
    public String deleteById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return "Teacher was successfully deleted!";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    @PutMapping("/update/teacherBy/{id}")
    public String updateById(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        teacherService.updateTeacher(id, teacherRequest);
        return "Teacher was successfully updated!";
    }
}