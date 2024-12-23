package com.elearning.wave.model.base;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private long optionId;
    private String options;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
