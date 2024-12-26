package com.elearning.wave.service;

import com.elearning.wave.dto.ModuleDTO;
import com.elearning.wave.model.base.Module;
import com.elearning.wave.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public ModuleDTO convertEntityToModuleDto(Module module) {
        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setModuleId(module.getModuleId());
        moduleDTO.setTitle(module.getTitle());
        moduleDTO.setContent(module.getContent());
        moduleDTO.setDescription(module.getDescription());

        return moduleDTO;
    }

    public ModuleDTO getModuleByIdOnSpecifiedCourse(long courseId, long modulesId) {
        Module module = moduleRepository.findByCourseCourseIdAndModuleId(courseId, modulesId).orElseThrow(()->new IllegalArgumentException("module not found"));
        return convertEntityToModuleDto(module);
    }

    public List<ModuleDTO> getModulesOnSpecifiedCourse(long courseId) {
        List<Module> module = moduleRepository.findByCourseCourseId(courseId).orElseThrow(()->new IllegalArgumentException("module not found"));
        return module
                .stream()
                .map(this::convertEntityToModuleDto)
                .collect(Collectors.toList());
    }
}
