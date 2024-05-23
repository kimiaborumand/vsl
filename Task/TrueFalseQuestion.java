package Task;

import Task.Question;

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(int questionNumber, String questionText) {
        super(questionNumber, questionText);
    }

    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("Answer with 'true' or 'false'");
    }
}