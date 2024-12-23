package com.elearning.wave.controller;

import com.elearning.wave.dto.QuizDTO;
import com.elearning.wave.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{moduleId}/quiz")
    public Optional<QuizDTO> getQuizOnSpecifiedModule(@PathVariable long moduleId) {
        return quizService.getQuizOnSpecifiedModule(moduleId);
    }
}
