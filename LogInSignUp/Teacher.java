package Task;

import LogInSignUp.CheckInfo;
import LogInSignUp.LogIn;
import Task.*;
import Task.Class;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Teacher extends Person {
    private ArrayList<Class> createdClasses = new ArrayList<>();
    private ArrayList<Quiz> createdQuizzes= new ArrayList<>();
    private ArrayList<Assignments> createdAssignments = new ArrayList<>();
    private ArrayList<Announcement> createdAnnouncements= new ArrayList<>();

    public Teacher
            (String firstName, String lastName, String username, String email, String phoneNumber, String password,String major,String id) {
        super(firstName, lastName, username, email, phoneNumber, password, major, id);
        Person.teachers.add(this);
    }


    Scanner scan = new Scanner(System.in);

    private int printClass(){
        int count=1;
        if (createdClasses!=null){
            for (Class c : createdClasses) {
                System.out.println(count+")"+c.getClassName());
                c.printStudent_Quiz();
                count++;
            }
        } else System.out.println("There is no class available!");
        int choose;
        while (true){
            try {
                choose = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!try again.");
                scan.next();
            }
        }
        screen();
        return choose;
    }
    private void printQuiz(){
        int count=1;
        if (createdQuizzes!=null){
            for (Quiz q : createdQuizzes) {
                System.out.print(count+")");
                q.printQuiz();
                count++;
            }
        } else System.out.println("There is no quiz available!");
        int choose;
        while (true){
            try {
                choose = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!try again.");
                scan.next();
            }
        }
        screen();
    }
    private void printAssignment(){
        int count=1;
        if (createdAssignments!=null){
            for (Assignments a : createdAssignments) {
                System.out.println(count+")"+a);
                count++;
            }
        } else System.out.println("There is no assignment available!");
        int choose;
        while (true){
            try {
                choose = scan.nextInt();
                if ((choose>=1 && choose<count )||choose==10||choose==11){
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!try again.");
                scan.next();
            }
        }

        System.out.flush();
        System.out.println(createdAssignments.get(count-2));
        createdAssignments.get(choose-2).printStudent();
        screen();
    }
    private void printAnnouncement(){
        int count=1;
        if (createdAnnouncements!=null){
            for (Announcement a : createdAnnouncements) {
                System.out.println(count+")"+a);
                count++;
            }
        } else System.out.println("There is no announcement available!");
        screen();
    }

    @Override
    public void screen() {
        int choose;
        super.screen();
        System.out.println("Teacher profile:{");
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Id: "+id+" }");
        System.out.println("1) classes");
        System.out.println("2) quizzes");
        System.out.println("3) assignment");
        System.out.println("4) announcement");
        System.out.println("5) new");
        while (true){
            try {
                choose = scan.nextInt();
                if ((choose>=1 && choose<=5 )||choose==10||choose==11){
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!try again.");
                scan.next();
            }
        }

//        System.out.print("\033[H\033[2J");
//        System.out.flush();
        switch (choose){
            case 1 :{
                printClass();
                break;
            }case 2 :{
                printQuiz();
                break;
            }case 3 :{
                printAssignment();
                break;
            }case 4 :{
                printAnnouncement();
                break;
            }case 5 :{
                addPage();
                break;
            }case 10 :{
                screen();
                break;
            }case 11 :{
                new LogIn();
                break;
            }
        }



    }
    public void addStudentToClass(Class course){
        String answer;
        label:
        do {
            System.out.println("Do you wanna add students?(y/n)");
            answer = scan.next();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("invalid answer try again:(y/n)");
                answer = scan.next();
            }
            System.out.println("Enter student first name:");
            String first = scan.next();
            System.out.println("Enter student last name:");
            String last = scan.next();
            System.out.println("Enter student id:");
            String id = scan.next();
            CheckInfo checkInfo = new CheckInfo();
            while (!checkInfo.isIdValidE(id, "Student")) {
                if (answer.equalsIgnoreCase("11")) {
                    addPage();
                    break label;
                } else if (answer.equalsIgnoreCase("10")) {
                    new LogIn();
                    break label;
                }
                System.out.println("invalid id,try again");
                answer = scan.next();
            }

            Student s = searchStudent(first, last, id);
            if (s != null) {
                course.setStudents(s);
            }
            System.out.println("Do you wanna continue?(y/n)");
            answer = scan.next();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("invalid answer try again:(y/n)");
                answer = scan.next();
            }

        }while (answer.equalsIgnoreCase("y"));

    }
    public Student searchStudent(String firstName , String lastName , String id){
        for (Student s : Person.students){
            if (s.getId().equalsIgnoreCase(id) && s.lastName.equalsIgnoreCase(lastName) && s.firstName.equalsIgnoreCase(firstName)){
                return s;
            }
        }
        return null;
    }

    public void addStudent(){
        super.screen();
        System.out.println("Choose a class");
        int index;
        while (true) {
            try {
                index = printClass();
                if (index==10 || index==11 || (0<=index&&index<=createdClasses.size())){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid entry!try again.");
                scan.next();
            }

        }
        if (index == 11) addPage();
        else if (index == 10) new LogIn();
        else {
            addStudentToClass(createdClasses.get(index - 1));
            addPage();
        }
    }
    public Class searchClass(String name){
        for (Class s : createdClasses){
            if (s.getClassName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }
    public void addAssignments(){
        super.screen();
        System.out.println("Enter assignment name:");
        String name = scan.next();
        System.out.println("Enter assignment deadline:");
        String deadline = scan.next();
        System.out.println("Enter question:");
        String q = scan.next();
        System.out.println("Enter class of this assignment:");
        String className = scan.next();
        if (name.equalsIgnoreCase("11") ||deadline.equalsIgnoreCase("11")||q.equalsIgnoreCase("11")) addPage();
        else if (name.equalsIgnoreCase("10")||deadline.equalsIgnoreCase("10")||q.equalsIgnoreCase("10")) new LogIn();
        else if (searchClass(className)!=null){
            createdAssignments.add(new Assignments(name, deadline, q,searchClass(className)));
            addPage();
        }
    }
    public void addAnnouncement(){
        super.screen();
        System.out.println("Enter an announcement(without pressing enter)");
        String answer =scan.next();
        if (answer.equalsIgnoreCase("11")) addPage();
        else if (answer.equalsIgnoreCase("10")) new LogIn();
        else {
            createdAnnouncements.add(new Announcement(answer));
            addPage();
        }
    }
    public void addClass(){
        super.screen();
        System.out.println("Enter new class name:");
        String answer =scan.next();
        if (answer.equalsIgnoreCase("11")) addPage();
        else if (answer.equalsIgnoreCase("10")) new LogIn();
        else {
            createdClasses.add(new Class(answer, this));
            addPage();
        }
    }
    public void addQuiz(){
        super.screen();
        System.out.println("Enter quiz title:");
        String name = scan.next();
        if (name.equalsIgnoreCase("11") ) addPage();
        else if (name.equalsIgnoreCase("10")) new LogIn();
        else {
            System.out.println("Enter the date of your quiz: (year/month/date): ");
            int y = scan.nextInt();
            int m = scan.nextInt();
            int d = scan.nextInt();
            System.out.println("Enter quiz duration: (hour.minute): ");
            double du = scan.nextDouble();
            createdQuizzes.add(new Quiz(name, new Date(y,m,d),du));
            addPage();
        }


    }
    public void addPage() {
        super.screen();
        System.out.println("1) add new class");
        System.out.println("2) add student to a class");
        System.out.println("3) add a quiz ");
        System.out.println("4) add an announcement");
        System.out.println("5) add an assignment");
        int choose;
        while (true) {
            try {
                choose = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry!try again.");
                scan.next();
            }
        }
        switch (choose) {
            case 1: {
                addClass();
                break;
            }
            case 2: {
                addStudent();
                break;
            }
            case 3: {
                addQuiz();
                break;
            }
            case 4: {
                addAnnouncement();
                break;
            }
            case 5: {
                addAssignments();
                break;
            }
            case 10: {
                new LogIn();
                break;
            }
            case 11: {
                screen();
                break;
            }
        }
    }



    @Override
    public String toString() {
        return "Teacher"+super.toString();
    }

    }


