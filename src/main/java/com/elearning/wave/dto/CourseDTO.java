package com.elearning.wave.dto;

import java.util.List;

public class CourseDTO {
    private long courseId;
    private String title;
    private String description;
    private List<ModuleDTO> moduleDTOS;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ModuleDTO> getModuleDTOS() {
        return moduleDTOS;
    }

    public void setModuleDTOS(List<ModuleDTO> moduleDTOS) {
        this.moduleDTOS = moduleDTOS;
    }
}
