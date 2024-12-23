package com.elearning.wave.dto;

import java.util.List;

public class QuizSubmitDTO {
    private long userId;
    private long quizId;
    private List<UserAnswerDTO> userAnswers;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public List<UserAnswerDTO> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswerS(List<UserAnswerDTO> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
