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
    private final ModuleService moduleService;

    @Autowired
    public CourseService(CourseRepository courseRepository, ModuleService moduleService) {
        this.courseRepository = courseRepository;
        this.moduleService = moduleService;
    }

    public CourseDTO convertEntityToDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setModuleDTOS(course.getModules()
                .stream()
                .map(moduleService::convertEntityToDto)
                .collect(Collectors.toList()));
        return courseDTO;
    }

    public List<CourseDTO> getAllCourse() {
        return courseRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public Optional<CourseDTO> getCourseById(long id) {
        return courseRepository.findById(id)
                .map(this::convertEntityToDto);
    }

    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }
}
