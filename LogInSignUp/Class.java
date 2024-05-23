package Task;

import java.util.ArrayList;
    public class Class {
        private String className;
        private ArrayList<Quiz> quizList = new ArrayList<>();
        private ArrayList<Student> students = new ArrayList<>();
        private final Teacher teacher;

        public String getClassName() {
            return className;
        }

        public void printStudent_Quiz(){
            System.out.println(className+" students:");
            if (students!=null){
                for (Student s : students) {
                    System.out.println(s);
                }
            } else System.out.println("There is no student!");
            System.out.println(className+" quizzes:");
            if (quizList!=null){
                for (Quiz q : quizList) {
                    if (q != null) System.out.println(q);
                }
            }else System.out.println("There is no quiz available!");
        }
        public void setStudents(Student student) {
            students.add(student);
        }

        public void addQuiz(Quiz quiz) {
            quizList.add(quiz);
            for (Student student : students) {
                student.getQuizzes().add(quiz);
            }
        }

        public Class(String className, Teacher teacher) {
            this.className = className;
            this.teacher = teacher;
        }

        @Override
        public String toString() {
            return "Class{" +
                    "teacher=" + teacher +
                    '}';
        }
    }

