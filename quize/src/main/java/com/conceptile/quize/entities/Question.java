package com.conceptile.quize.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "questions_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
