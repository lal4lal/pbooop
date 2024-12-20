package com.elearning.wave.model.base;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    protected long questionId;
    @Column(name = "question_text")
    protected String questionText;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    @ElementCollection
    @CollectionTable(name = "options", joinColumns = @JoinColumn(name = "question_id"))
    protected List<String> options;
    @ElementCollection
    @CollectionTable(name = "correct_answers", joinColumns = @JoinColumn(name = "question_id"))
    protected List<String> correctAnswer;

    public Question(long questionId, String questionText, Quiz quiz, List<String> options, List<String> correctAnswer) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.quiz = quiz;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public abstract boolean checkAnswer(List<String> userAnswer);
    public long getQuestionId() { return questionId; }
    public void setQuestionId(long questionId) { this.questionId = questionId; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }
    public List<String> getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(List<String> correctAnswer) { this.correctAnswer = correctAnswer; }
}
