package Task;

import Task.Question;

class MultipleChoiceQuestion extends Question {
    private String[] options;

    public MultipleChoiceQuestion(int questionNumber, String questionText, String[] options) {
        super(questionNumber, questionText);
        this.options = options;
    }

    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("Options:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}
