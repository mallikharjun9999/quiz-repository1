# quiz-repository1
Quiz Repository contains quiz REST API which was created by using Spring Boot.

To run Quiz REST API , just clone it and run ( no need to setup database as database file already in project directory inside data folder).

Asumptions about project : 
                         1) I already made this project to run on persistance mode as database file located with in project directory with in data folder.
                         2) I already added 10 questions in the database to check wheather API works well or not(no need to add any questions by using end point in controller as it will give error because, there not implemented sequence sync in the project.
                         3) if you want to check add questions end point in controll then need to delete data folder(which will delete database file), then if you restart project again new database file will create and you can check by adding questions to database by  @PostMapping("add/question/"). But initially there are 10 questions already, you can play with them to check other end points like signup new user, submit answer, checking results.
                         4)Firstly, you can find main method to run REST API inside com.conceptile.quiz package, there is a class as QuizApplication, inside this class you can find main method to run and you can access API on http://localhost:8080/quiz/
                         5)Use postman to check endpoints, all end points will work with json payloads only.
                         6)As database file already consists 10 question, first use signup endpoint(http://localhost:8080/quiz/signup/user/) to add new user in to database.
                         7)After you can get questions on (http://localhost:8080/quiz/get/questions/) by sending user entity payload(avoid adding vaule to id fields for every entity as they are defined automatically assiging values to Id's of every entity ). 
                         8)you can access submit answer endpoint on ( http://localhost:8080/quiz/submit/answer/ )
                         need to send json payload including user and question entity payloads with out adding values to id attributes.
                         9)you can get results of quiz for user by access on http://localhost:8080/quiz/quiz/result/{username}.


