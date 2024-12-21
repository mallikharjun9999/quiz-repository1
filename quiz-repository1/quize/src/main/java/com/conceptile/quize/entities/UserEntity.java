package com.conceptile.quize.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name = "user_tbl")
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

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, String firstName, String lastName, Set<Question> answeredQuestions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.answeredQuestions = answeredQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Question> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(Set<Question> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
