package com.conceptile.quize.entities;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "questions_tbl")
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(
            name = "question",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String question;

    @Column(
            name = "option1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String option1;

    @Column(
            name = "option2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String option2;

    @Column(
            name = "option3",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String option3;

    @Column(
            name = "option4",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String option4;

    @Column(
            name = "correct_answer",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String correctAnswer;

    public Question() {
    }

    public Question(Long id, String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
