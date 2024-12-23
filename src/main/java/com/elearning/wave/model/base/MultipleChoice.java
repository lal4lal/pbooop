package com.elearning.wave.model.base;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("MULTIPLE_CHOICE")
public class MultipleChoice extends Question {

    public MultipleChoice(long questionId, String questionText, Quiz quiz, List<Options> options, List<CorrectAnswer> correctAnswer) {
        super(questionId, questionText, quiz, options, correctAnswer);
    }

    public MultipleChoice() {
    }

    @Override
    public boolean checkAnswer(List<String> userAnswer) {
        return correctAnswer.containsAll(userAnswer) && userAnswer.containsAll(correctAnswer);
    }
}
