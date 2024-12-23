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
    private final QuizService quizService;

    @Autowired
    public ModuleService(ModuleRepository moduleRepository, QuizService quizService) {
        this.moduleRepository = moduleRepository;
        this.quizService = quizService;
    }

    public ModuleDTO convertEntityToModuleDto(Module module) {
        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setModuleId(module.getModuleId());
        moduleDTO.setTitle(module.getTitle());
        moduleDTO.setContent(module.getContent());
        moduleDTO.setDescription(module.getDescription());
        moduleDTO.setQuizDTO(quizService.convertEntityToQuizDto(module.getQuiz()));

        return moduleDTO;
    }

    public Optional<ModuleDTO> getModuleByIdOnSpecifiedCourse(long courseId, long modulesId) {
        return moduleRepository.findByCourseCourseIdAndModuleId(courseId, modulesId)
                .map(this::convertEntityToModuleDto);
    }

    public List<ModuleDTO> getModulesOnSpecifiedCourse(long courseId) {
        return moduleRepository.findByCourseCourseId(courseId)
                .stream()
                .map(this::convertEntityToModuleDto)
                .collect(Collectors.toList());
    }
}
