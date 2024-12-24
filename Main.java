public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding sample questions
        quiz.addQuestion(new Question(
                "What is the capital of France?",
                new String[]{"London", "Berlin", "Paris", "Madrid"},
                2, // index of correct answer (Paris)
                10  // time limit in seconds
        ));

        quiz.addQuestion(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"},
                1, // Mars
                15
        ));

        quiz.addQuestion(new Question(
                "What is 2 + 2 * 2?",
                new String[]{"6", "8", "4", "10"},
                0, // 6
                10
        ));

        // Start the quiz
        quiz.start();
    }
}