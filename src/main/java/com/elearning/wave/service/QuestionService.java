package com.elearning.wave.service;

import com.elearning.wave.dto.QuestionDTO;
import com.elearning.wave.model.base.Question;
import com.elearning.wave.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionDTO convertEntityToDto(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestionId(question.getQuestionId());
        questionDTO.setQuestionText(question.getQuestionText());
        questionDTO.setOptions(question.getOptions());

        return questionDTO;
    }

    public List<QuestionDTO> getAllQuestionOnSpecifiedQuiz(long quizId) {
        return questionRepository.findByQuizQuizId(quizId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public QuestionDTO getQuestionByIdOnSpecifiedQuiz(long quizId, long questionId) {
        return convertEntityToDto(questionRepository.findByQuizQuizIdAndQuestionId(quizId, questionId));
    }
}
