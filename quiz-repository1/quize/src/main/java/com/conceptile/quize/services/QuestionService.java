package com.conceptile.quize.services;

import com.conceptile.quize.entities.Question;
import com.conceptile.quize.repositories.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionService implements QuestionServiceInterface {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

}
