package com.elearning.wave.controller;

import com.elearning.wave.dto.ModuleDTO;
import com.elearning.wave.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class ModuleController {

    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/{courseId}/modules")
    public List<ModuleDTO> getModulesOnSpecifiedCourse(@PathVariable long courseId) {
        return moduleService.getModulesOnSpecifiedCourse(courseId);
    }

    @GetMapping("/{courseId}/modules/{modulesId}")
    public Optional<ModuleDTO> getModuleByIdOnSpecifiedCourse(@PathVariable long courseId, @PathVariable long modulesId) {
        return moduleService.getModuleByIdOnSpecifiedCourse(courseId, modulesId);
    }

}
