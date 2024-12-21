package com.conceptile.quize.repositories;

import com.conceptile.quize.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> getQuestionByQuestion(String question);

    Optional<Question> findByQuestion(String question);
}
