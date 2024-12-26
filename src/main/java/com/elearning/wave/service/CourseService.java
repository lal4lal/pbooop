package com.elearning.wave.service;

import com.elearning.wave.dto.CourseDTO;
import com.elearning.wave.model.base.Course;
import com.elearning.wave.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO convertEntityToCourseDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setTitle(course.getTitle());

        return courseDTO;
    }

    public List<CourseDTO> getAllCourse() {
        return courseRepository.findAll()
                .stream()
                .map(this::convertEntityToCourseDto)
                .collect(Collectors.toList());
    }

    public Optional<CourseDTO> getCourseById(long id) {
        return courseRepository.findById(id)
                .map(this::convertEntityToCourseDto);
    }

    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }
}
