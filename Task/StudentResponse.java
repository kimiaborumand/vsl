package Task;

class StudentResponse {
    private Question question;
    private String answer;

    public StudentResponse(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void displayResponse() {
        System.out.println("Question " + question.questionNumber + ": " + answer);
    }
}
