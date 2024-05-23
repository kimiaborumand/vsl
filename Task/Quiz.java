package Task;

import LogInSignUp.CheckInfo;
import LogInSignUp.LogIn;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Quiz {
    private String quizName;
    private Date quizTime;
    private double duration;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(String examName, Date examTime,double duration) {
        this.quizName = examName;
        this.quizTime = examTime;
        this.duration=duration;
        Scanner scan = new Scanner(System.in);
        String answer;
        label:
        do {
            System.out.println("Enter your question type :\n 1.Multiple Choice\n 2.Essay\n 3.True & False)");
            answer = scan.next();
            while (!answer.equalsIgnoreCase("1") && !answer.equalsIgnoreCase("2") && !answer.equalsIgnoreCase("3")) {
                System.out.println("invalid answer try again:(1.Multiple Choice\n 2.Essay\n 3.True & False)");
                answer = scan.next();
            }
            switch (answer) {
                case "1" :
                System.out.println("Enter Questions number :");
                int number = scan.nextInt();
                System.out.println("Enter Questions text:");
                String text = scan.next();
                String[] options = new String[4];
                for(int i =0 ; i<4 ; i++){
                    int j =i+1;
                    System.out.println("option" + j + " :");
                    options[i] = scan.next();
                }
                addMultipleQ(number,text,options);
                break ;
                case "2" :
                    System.out.println("Enter Questions number :");
                    int number2 = scan.nextInt();
                    System.out.println("Enter Questions text:");
                    String text2 = scan.next();
                    addEssayQ(number2, text2);
                    break ;
                case "3" :
                    System.out.println("Enter Questions number :");
                    int number3 = scan.nextInt();
                    System.out.println("Enter Questions text:");
                    String text3 = scan.next();
                    addTrueFalseQ(number3, text3);
                    break ;
            }
            System.out.println("Do you wanna continue?(y/n)");
            answer = scan.next();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("invalid answer try again:(y/n)");
                answer = scan.next();
            }
        }while (answer.equalsIgnoreCase("y"));
    }




    public void addEssayQ(int questionNumber, String questionText){
       EssayQuestion q = new EssayQuestion( questionNumber, questionText);
       questions.add(q);
    }
    public void addMultipleQ(int questionNumber, String questionText, String[] options){
        MultipleChoiceQuestion q = new MultipleChoiceQuestion( questionNumber,  questionText, options);
        questions.add(q);
    }
    public void addTrueFalseQ(int questionNumber, String questionText){
       TrueFalseQuestion q = new TrueFalseQuestion( questionNumber, questionText);
        questions.add(q);
    }

    public void startQuiz() {
        System.out.println("Quiz: " + quizName);
        System.out.println("Time: " + quizTime);
        System.out.println("--------");
        for (Question question : questions) {
            question.displayQuestion();
        }
    }


    public void printQuiz() {
        System.out.println("Quiz{" +
                "\nquizName='" + quizName  +
                "\nquizTime=" + quizTime +
                "\nduration=" + duration );
        for (Question q : questions){
            q.displayQuestion();
        }
    }
}