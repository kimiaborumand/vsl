package Task;

public class Crew extends Person {
    @Override
    public String toString() {
        return "Crew"+super.toString();
    }
    public Crew(String firstName, String lastName, String userName, String email, String phoneNumber, String password,String major,String id) {
        super(firstName, lastName, userName, email, phoneNumber, password, major, id);
        Person.crews.add(this);
    }
}
