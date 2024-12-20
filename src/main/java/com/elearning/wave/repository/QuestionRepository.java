package com.elearning.wave.repository;

import com.elearning.wave.model.base.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findByQuizQuizId(long quizId);
    public Question findByQuizQuizIdAndQuestionId(long quizId, long questionId);
}
