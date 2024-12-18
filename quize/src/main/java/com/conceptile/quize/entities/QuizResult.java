package com.conceptile.quize.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quiz_result_tbl")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
}
