package com.conceptile.quize.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_result_tbl")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_FK")
    )
    private UserEntity user;

    @Column(name = "total")
    private int totalAnswered;

    @Column(name = "correct")
    private Long correctAnswered;

    @Column(name = "wrong")
    private Long wrongAnswered;
    @Column(name = "unanswered")
    private Long unanswered;
    @Column(name = "total_questions")
    private Long totalQuestions;

    public QuizResult() {
    }

    public QuizResult(Long id, UserEntity user, int totalAnswered, Long correctAnswered, Long wrongAnswered, Long unanswered, Long totalQuestions) {
        this.id = id;
        this.user = user;
        this.totalAnswered = totalAnswered;
        this.correctAnswered = correctAnswered;
        this.wrongAnswered = wrongAnswered;
        this.unanswered = unanswered;
        this.totalQuestions = totalQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getTotalAnswered() {
        return totalAnswered;
    }

    public void setTotalAnswered(int totalAnswered) {
        this.totalAnswered = totalAnswered;
    }

    public Long getCorrectAnswered() {
        return correctAnswered;
    }

    public void setCorrectAnswered(Long correctAnswered) {
        this.correctAnswered = correctAnswered;
    }

    public Long getWrongAnswered() {
        return wrongAnswered;
    }

    public void setWrongAnswered(Long wrongAnswered) {
        this.wrongAnswered = wrongAnswered;
    }

    public Long getUnanswered() {
        return unanswered;
    }

    public void setUnanswered(Long unanswered) {
        this.unanswered = unanswered;
    }

    public Long getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Long totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
}
