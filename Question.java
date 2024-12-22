class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;
    private int timeLimit; // in seconds

    public Question(String questionText, String[] options, int correctAnswer, int timeLimit) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}
