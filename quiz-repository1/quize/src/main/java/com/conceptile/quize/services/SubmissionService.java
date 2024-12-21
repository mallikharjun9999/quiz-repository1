package com.conceptile.quize.services;

import com.conceptile.quize.entities.Question;
import com.conceptile.quize.entities.QuizResult;
import com.conceptile.quize.entities.Submission;
import com.conceptile.quize.entities.UserEntity;
import com.conceptile.quize.repositories.QuestionRepository;
import com.conceptile.quize.repositories.QuizResultRepository;
import com.conceptile.quize.repositories.SubmissionRepository;
import com.conceptile.quize.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubmissionService implements SubmissionServiceInterface {
    private final SubmissionRepository submissionRepository;
    private final QuizResultRepository quizResultRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public SubmissionService(SubmissionRepository submissionRepository,
                             QuizResultRepository quizResultRepository,
                             QuestionRepository questionRepository,
                             UserRepository userRepository) {
        this.submissionRepository = submissionRepository;
        this.quizResultRepository = quizResultRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void submit(Submission submission) {
        Question question = submission.getQuestion();
        if (question.getId() == null) {
            Optional<Question> existingQuestion = questionRepository.findByQuestion(question.getQuestion());
            Question finalQuestion = question;
            question = existingQuestion.orElseGet(() -> questionRepository.save(finalQuestion));
        }
        submission.setQuestion(question);

        UserEntity user = submission.getUser();
        if(user.getId() == null) {
            Optional<UserEntity> existingUser = userRepository.findByUsername(user.getUsername());
            UserEntity finalUser = user;
            user = existingUser.orElseGet(() -> userRepository.save(finalUser));
        }
        submission.setUser(user);

        user.getAnsweredQuestions().add(question);
        submissionRepository.save(submission);
        userRepository.save(user);
    }

    @Override
    public QuizResult getResults(UserEntity user) {
        List<Submission> submissions = submissionRepository.findByUser(user);
        int totalAnswered = submissions.size();
        long correctlyAnswered = submissions.stream()
                .filter(sub ->
                        sub.getAnswer().equals(sub.getQuestion().getCorrectAnswer())
                )
                .count();
        long totalQuestions = questionRepository.count();
        long unAnsweredOnes = totalQuestions - totalAnswered;
        long wrongAnswers = totalAnswered - correctlyAnswered;
        QuizResult quizResult = new QuizResult();
        quizResult.setUser(user);
        quizResult.setTotalAnswered(totalAnswered);
        quizResult.setCorrectAnswered(correctlyAnswered);
        quizResult.setWrongAnswered(wrongAnswers);
        quizResult.setUnanswered(unAnsweredOnes);
        quizResult.setTotalQuestions(totalQuestions);
        return quizResultRepository.save(quizResult);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
