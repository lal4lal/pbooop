package com.elearning.wave.model.base;

import jakarta.persistence.*;

@Entity
@Table(name = "correct_answers")
public class CorrectAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correct_answer_id")
    private long correctAnswerId;
    @Column(name = "correct_answer")
    private String correctAnswer;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
