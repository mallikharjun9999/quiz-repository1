package com.conceptile.quize.controllers;
import com.conceptile.quize.entities.Question;
import com.conceptile.quize.entities.QuizResult;
import com.conceptile.quize.entities.Submission;
import com.conceptile.quize.entities.UserEntity;
import com.conceptile.quize.services.QuestionServiceInterface;
import com.conceptile.quize.services.SubmissionServiceInterface;
import com.conceptile.quize.services.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/quiz/")
public class QuizController {
    private final UserServiceInterface userService;
    private final QuestionServiceInterface questionService;
    private final SubmissionServiceInterface submissionService;

    public QuizController(UserServiceInterface userService,
                          QuestionServiceInterface questionService,
                          SubmissionServiceInterface submissionService) {
        this.userService = userService;
        this.questionService = questionService;
        this.submissionService = submissionService;
    }

    Random random = new Random();

     @PostMapping("signup/user/")
    public ResponseEntity<String> signup(@RequestBody UserEntity user) {
        try {
            UserEntity userEntity = userService.addUser(user);
            return ResponseEntity.ok("User with username: " + userEntity.getUsername() + " added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

      @PostMapping("add/question/")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        Question question1 = questionService.addQuestion(question);
        if(question1 == null){ return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error"); }
        return ResponseEntity.ok("Question added successfully ");
    }

     @GetMapping("get/questions/")
    public ResponseEntity<?> getQuestions(@RequestBody UserEntity user){
        UserEntity userEntity = userService.findUser(user);
        if(userEntity == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        List<Question> totalQuestions = questionService.getQuestions();
         List<Question> unAnsweredQuestions = totalQuestions.stream()
                 .filter(
                         question ->
                                 !userEntity.getAnsweredQuestions().contains(question)
                 )
                 .toList();
         if(unAnsweredQuestions.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No more questions found");
         }
         int randomInt = random.nextInt(unAnsweredQuestions.size());
         return ResponseEntity.ok(unAnsweredQuestions.get(randomInt));
     }


    @PostMapping("submit/answer/")
    public ResponseEntity<String> submitAnswer(@RequestBody Submission submission){
        submissionService.submit(submission);
        return ResponseEntity.ok("Submission submitted");
    }

    @GetMapping("/quiz/result/{username}")
    public ResponseEntity<?> getQuizResult(@PathVariable String username) {
         try {
             UserEntity user = submissionService.findUserByUsername(username);
             if (user == null) {
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
             }
             QuizResult results = submissionService.getResults(user);
             return ResponseEntity.ok(results);
         }
         catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
         }
    }

}
