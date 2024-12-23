package com.elearning.wave.controller;

import com.elearning.wave.dto.CourseDTO;
import com.elearning.wave.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public List<CourseDTO> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public Optional<CourseDTO> getCourseById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }
}
