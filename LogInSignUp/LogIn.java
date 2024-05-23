package LogInSignUp;

import Task.Crew;
import Task.Person;
import Task.Student;
import Task.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LogIn extends JFrame implements ActionListener {
//    private static LogIn logIn=new LogIn();;
//    public static LogIn getInstance() {
//        return logIn;
//    }
    private final CheckInfo checkInfo = new CheckInfo();
    private JTextField idField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton signUpButton;
    private JPanel logInTextPanel;
    private JPanel login;
    private JLabel IDLabel;
    private JLabel passwordLabel;
    private JLabel notAMemberLabel;
    private JLabel VLSLabel;
    private JLabel welcome2Label;
    private JLabel loginText;
    private JPanel infoPanel;
    private JCheckBox showPassword;

    public void createUIComponents(){
        login = new JPanel();
        infoPanel = new JPanel();
        logInTextPanel = new JPanel();
        idField1 = new JTextField();
        passwordField1 = new JPasswordField();
        loginText = new JLabel();
        IDLabel = new JLabel();
        passwordLabel = new JLabel();
        notAMemberLabel = new JLabel();
        welcome2Label = new JLabel();
        VLSLabel = new JLabel();
        loginButton = new JButton();
        signUpButton=new JButton();
        showPassword = new JCheckBox();

    }

    public LogIn() {
        showPassword.addActionListener(this);
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        this.setContentPane(login);
        this.setMinimumSize(new Dimension(540,400));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (showPassword.isSelected()){
            passwordField1.setEchoChar((char)0);
        } else passwordField1.setEchoChar('\u2022');

        if (e.getSource()==loginButton) {
            if (checkInfo.isIdValid(idField1.getText()) && checkInfo.isPasswordValid(Arrays.toString(passwordField1.getPassword())))
            {
                if (passwordField1.getPassword().length==4){
                    for (Crew c : Person.crews){
                        if (c.getId().equalsIgnoreCase(idField1.getText()) && c.getPassword().equalsIgnoreCase(Arrays.toString(passwordField1.getPassword()))){
                            //open page for c
                        }
                    }
                }
                else if (passwordField1.getPassword().length==6){
                    for (Teacher t : Person.teachers){
                        if (t.getId().equalsIgnoreCase(idField1.getText()) && t.getPassword().equalsIgnoreCase(Arrays.toString(passwordField1.getPassword()))){
                            System.out.println("ttttttttttttt");
                            this.dispose();
                            t.screen();
                        }
                    }
                }
                else if (passwordField1.getPassword().length==10){
                    for (Student s : Person.students){
                        if (s.getId().equalsIgnoreCase(idField1.getText()) && s.getPassword().equalsIgnoreCase(Arrays.toString(passwordField1.getPassword()))){
                            //open page for c
                        }
                    }
                }

            } else{
                idField1.setText(null);
                passwordField1.setText(null);
            }

        } else if (e.getSource()==signUpButton) {
            this.dispose();
            new SignUp();
        }
    }
}
