package com.elearning.wave.service;

import com.elearning.wave.dto.QuizDTO;
import com.elearning.wave.model.base.Quiz;
import com.elearning.wave.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionService questionService;

    @Autowired
    public QuizService(QuizRepository quizRepository, QuestionService questionService) {
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }

    public QuizDTO convertEntityToDto(Quiz quiz) {
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setQuizId(quiz.getQuizId());
        quizDTO.setRewardPoint(quiz.getRewardPoint());
        quizDTO.setQuestionDTO(quiz.getQuestion()
                .stream()
                .map(questionService::convertEntityToDto)
                .collect(Collectors.toList()));

        return quizDTO;
    }

    public Optional<QuizDTO> getQuizOnSpecifiedModule(long moduleId) {
        return quizRepository.findByModulesModuleId(moduleId)
                .map(this::convertEntityToDto);
    }
}
