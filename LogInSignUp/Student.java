package Task;

import Task.*;
import Task.Class;

import java.util.ArrayList;

public class Student extends Person implements QuizInterface {
    private final ArrayList<Class> classes= new ArrayList<>();
    private final ArrayList<Quiz> quizzes= new ArrayList<>();
    private final ArrayList<Announcement> announcements= new ArrayList<>();
    private final ArrayList<Assignments> assignments= new ArrayList<>();

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    private void printClass_Quiz(){
        if (classes!= null){
            for (Class c : classes) {
                System.out.println(c);
            }
        } else System.out.println("There is no class available!");
        if (quizzes!=null){
            for (Quiz q : quizzes) {
                if (q != null) System.out.println(q);
            }
        }else System.out.println("There is no quiz available!");
    }

    public Student
            (String firstName, String lastName, String userName, String email, String phoneNumber, String password,String major,String id) {
        super(firstName, lastName, userName, email, phoneNumber, password,major,id);
        Person.students.add(this);
    }
    @Override
    public String toString() {
        return "Student"+super.toString();
    }

    @Override
    public void screen() {
        super.screen();
        System.out.println("Student profile:{");
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Id: "+id+" }");
        printClass_Quiz();
    }


    @Override
    public void displayQuizInfo() {
        QuizManager.displayQuizInfo();
    }

    @Override
    public boolean startQuiz() {
        return QuizManager.startQuiz();
    }
}
