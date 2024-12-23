package com.elearning.wave.model.base;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import javax.swing.text.html.Option;
import java.util.List;

@Entity
@DiscriminatorValue("SINGLE_CHOICE")
public class SingleChoice extends Question {

    public SingleChoice(long questionId, String questionText, Quiz quiz, List<Options> options, List<CorrectAnswer> correctAnswer) {
        super(questionId, questionText, quiz, options, correctAnswer);
    }

    public SingleChoice() {
    }

    @Override
    public boolean checkAnswer(List<String> userAnswer) {
        return correctAnswer.equals(userAnswer);
    }
}
