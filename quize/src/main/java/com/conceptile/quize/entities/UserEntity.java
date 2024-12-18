package com.conceptile.quize.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user_tbl")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @SequenceGenerator(
            name = "user_id_generator",
            sequenceName = "user_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
    generator = "user_id_generator")
    private Long id;

    @Column(
            name = "username",
            unique = true,
            nullable = false,
            columnDefinition = "TEXT",
            length = 30
    )
    private String username;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT",
            length = 30
    )
    private String password;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT",
            length = 30
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT",
            length = 30
    )
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "user_answered_questions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id") )
    private Set<Question> answeredQuestions = new HashSet<>();

}
