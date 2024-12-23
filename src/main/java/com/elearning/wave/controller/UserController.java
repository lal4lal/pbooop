package com.elearning.wave.controller;

import com.elearning.wave.dto.EnrollRequestDTO;
import com.elearning.wave.dto.EnrolledCourseDTO;
import com.elearning.wave.dto.UserDTO;
import com.elearning.wave.service.EnrolledCourseService;
import com.elearning.wave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final EnrolledCourseService enrolledCourseService;

    @Autowired
    public UserController(UserService userService, EnrolledCourseService enrolledCourseService) {
        this.userService = userService;
        this.enrolledCourseService = enrolledCourseService;
    }

    @GetMapping("/{userId}")
    public Optional<UserDTO> getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/{userId}/courses")
    public List<EnrolledCourseDTO> getUserEnrolledCoursesById(@PathVariable long userId) {
        return enrolledCourseService.getUserEnrolledCoursesById(userId);
    }

    @PostMapping("/enroll")
    public void enrollCourse(@RequestBody EnrollRequestDTO enrollRequestDTO) {
        enrolledCourseService.enrollCourse(enrollRequestDTO);
    }
}
