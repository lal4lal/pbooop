package com.elearning.wave.controller;

import com.elearning.wave.dto.QuestionDTO;
import com.elearning.wave.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{quizId}")
    public List<QuestionDTO> getAllQuestionOnSpecifiedQuiz(@PathVariable long quizId) {
        return questionService.getAllQuestionOnSpecifiedQuiz(quizId);
    }

    @GetMapping("/{quizId}/question/{questionId}")
    public QuestionDTO getQuestionByIdOnSpecifiedQuiz(@PathVariable long quizId, @PathVariable long questionId) {
        return questionService.getQuestionByIdOnSpecifiedQuiz(quizId, questionId);
    }

}
