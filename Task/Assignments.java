package Task;

import java.util.ArrayList;

public class Assignments {
    public ArrayList<Student> assignmentsStudent= new ArrayList<>();
    String name;
    String deadline;
    String question;
    Class aClass;
    String answer;
    Student student;

    public Assignments(String name,String deadline , String question,Class aClass) {
        this.name = name;
        this.deadline =deadline;
        this.question=question;
        this.aClass=aClass;
    }
    public  void printStudent(){
        int count=1;
        if (assignmentsStudent!=null){
            for (Student s : assignmentsStudent) {
                System.out.println(count+")"+s);
                count++;
                //print assignment
            }
        } else System.out.println("No one upload this assignments!");
    }

    @Override
    public String toString() {
        return "name='" + name +
                "\ndeadline='" + deadline +
                "\nquestion='" + question ;
    }
}
