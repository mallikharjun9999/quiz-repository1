package com.conceptile.quize.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "submitted_answers_tbl")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "answer",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String answer;
    @ManyToOne
    @JoinColumn(
            name = "question_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "question_FK")
    )
    private Question question;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_FK")
    )
    private UserEntity user;

    public Submission() {
    }

    public Submission(Long id, String answer, Question question, UserEntity user) {
        this.id = id;
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
