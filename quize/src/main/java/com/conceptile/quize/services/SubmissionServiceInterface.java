package com.conceptile.quize.services;

import com.conceptile.quize.entities.QuizResult;
import com.conceptile.quize.entities.Submission;
import com.conceptile.quize.entities.UserEntity;


public interface SubmissionServiceInterface {
    void submit(Submission submission);

    QuizResult getResults(UserEntity user);

    UserEntity findUserByUsername(String username);
}
