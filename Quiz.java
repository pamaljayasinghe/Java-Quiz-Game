import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner scanner;
    private boolean timeUp;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You'll have limited time to answer each question.");
        System.out.println("Let's begin!\n");

        for (int i = 0; i < questions.size(); i++) {
            if (!askQuestion(questions.get(i), i + 1)) {
                break;
            }
        }

        showFinalScore();
    }

    private boolean askQuestion(Question question, int questionNumber) {
        System.out.println("Question " + questionNumber + ":");
        System.out.println(question.getQuestionText());

        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        timeUp = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up!");
                System.out.println("Press Enter to continue...");
            }
        }, question.getTimeLimit() * 1000);

        System.out.print("\nYour answer (1-" + options.length + "): ");

        int answer;
        try {
            answer = scanner.nextInt();
            if (timeUp) {
                System.out.println("Sorry, time's up! Moving to the next question.");
                timer.cancel();
                return true;
            }
            timer.cancel();

            if (answer < 1 || answer > options.length) {
                System.out.println("Invalid answer! Question skipped.");
                return true;
            }

            if (question.isCorrect(answer - 1)) {
                System.out.println("Correct! +1 point");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input! Quiz ended.");
            return false;
        }

        System.out.println("\nCurrent score: " + score + "\n");
        return true;
    }

    private void showFinalScore() {
        System.out.println("\n--- Quiz Completed! ---");
        System.out.println("Final Score: " + score + "/" + questions.size());
        double percentage = (double) score / questions.size() * 100;
        System.out.println("Percentage: " + String.format("%.1f%%", percentage));
    }
}
