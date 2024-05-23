package Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Person {
    public static ArrayList<Student> students= new ArrayList<>();
    public static ArrayList<Teacher> teachers= new ArrayList<>();
    public static ArrayList<Crew> crews= new ArrayList<>();

    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String email;
    protected String phoneNumber;
    protected String password;
    protected String major;
    protected String id;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public String getPassword() {
        return password;
    }

    public Person(String firstName, String lastName, String userName , String email, String phoneNumber, String password, String major, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.major = major;
        this.id= id;
    }

    public void screen(){
        System.out.println("Home(10)/Back(11)");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        System.out.println("Current Date and Time: " + formattedNow);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) && Objects.equals(userName, person.userName) &&
                Objects.equals(email, person.email) && Objects.equals(phoneNumber, person.phoneNumber) &&
                Objects.equals(password, person.password) && Objects.equals(major, person.major);
    }

    @Override
    public String toString() {
        return "{" +
                "\nfirstName='" + firstName +
                "\nlastName='" + lastName +
                "\nuserName='" + userName +
                "\nemail='" + email +
                "\nphoneNumber='" + phoneNumber +
                "\npassword='" + password +
                "\nmajor='" + major +
                "\nid=" + id +
                "\n}";
    }
}