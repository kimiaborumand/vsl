package Task;

import java.util.Date;
import java.util.Scanner;

public class QuizManager {
    private static String quizName;
    private static Date quizTime;

    public QuizManager(String quizName, Date quizTime) {
        this.quizName = quizName;
        this.quizTime = quizTime;
    }

    public static void displayQuizInfo() {
        System.out.println("quiz Name: " + quizName);
        System.out.println("quiz Time: " + quizTime);
    }

    public static boolean startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'yes' to start the quiz:");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("yes");
    }
}
