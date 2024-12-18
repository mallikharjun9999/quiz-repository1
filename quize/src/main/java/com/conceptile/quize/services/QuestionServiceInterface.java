package com.conceptile.quize.services;

import com.conceptile.quize.entities.Question;

import java.util.List;

public interface QuestionServiceInterface {
    List<Question> getQuestions();

    Question addQuestion(Question question);
}

