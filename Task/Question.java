package Task;

class Question {
    protected int questionNumber;
    protected String questionText;

    public Question(int questionNumber, String questionText) {
        this.questionNumber = questionNumber;
        this.questionText = questionText;
    }

    public void displayQuestion() {
        System.out.println("Question " + questionNumber + ": " + questionText);
    }
}