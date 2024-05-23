package LogInSignUp;

import Task.Crew;
import Task.Student;
import Task.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class SignUp extends JFrame implements ActionListener {
    private JPanel signUpPanel;
    private JPanel signupTextPanel;
    private JLabel signupTextLabel;
    private JLabel firstName;
    private JLabel lastNAme;
    private JLabel username;
    private JLabel major;
    private JLabel id;
    private JLabel email;
    private JLabel phoneNum;
    private JLabel role;
    private JLabel password;
    private JLabel repeatPassword;
    private JTextField textFieldId;
    private JTextField textFieldMajor;
    private JTextField textFieldUsername;
    private JTextField textFieldLastName;
    private JTextField textFieldFirstName;
    private JTextField textFieldEmail;
    private JTextField textFieldPhone;
    private JComboBox comboBoxRole;
    private JPasswordField passwordField;
    private JTextField textFieldPassword;
    private JButton signUpButton;
    private JButton logInButton;
    private JPanel panel;

    public void createUIComponents(){
        panel = new JPanel();
        signUpPanel = new JPanel();
        signupTextPanel = new JPanel();
        textFieldId = new JTextField();
        textFieldMajor = new JTextField();
        textFieldUsername = new JTextField();
        textFieldLastName = new JTextField();
        textFieldFirstName = new JTextField();
        textFieldEmail = new JTextField();
        textFieldPhone = new JTextField();
        textFieldPassword = new JTextField();
        passwordField = new JPasswordField();
        signupTextLabel = new JLabel();
        firstName = new JLabel();
        lastNAme = new JLabel();
        username = new JLabel();
        major = new JLabel();
        id = new JLabel();
        email = new JLabel();
        phoneNum = new JLabel();
        role = new JLabel();
        password = new JLabel();
        repeatPassword = new JLabel();
        logInButton = new JButton();
        signUpButton=new JButton();
        comboBoxRole = new JComboBox<>();

    }

    private final CheckInfo checkInfo = new CheckInfo();

    boolean[] sw = {false,false,false,false,false,false,false,false};
    private boolean checkInformation(){
        if (checkInfo.isNameValid(textFieldFirstName.getText())) {
            sw[0] = true;
            textFieldFirstName.setText(null);
        }
        if (checkInfo.isNameValid(textFieldLastName.getText())) {
            sw[1] = true;
            textFieldLastName.setText(null);
        }
        if (!checkInfo.isUsernameValid(textFieldUsername.getText())) {
            sw[2] = true;
            textFieldUsername.setText(null);
        }
        if (checkInfo.isNameValid(textFieldMajor.getText())) {
            sw[3] = true;
            textFieldMajor.setText(null);
        }
        if (!checkInfo.isIdValidE(textFieldId.getText(), Objects.requireNonNull(comboBoxRole.getSelectedItem()).toString())) {
            sw[4] = true;
            textFieldId.setText(null);
        }
        if (!checkInfo.isEmailValid(textFieldEmail.getText())) {
            sw[5] = true;
            textFieldEmail.setText(null);
        }
        if (!checkInfo.isPhoneNumValid(textFieldPhone.getText())) {
            sw[6] = true;
            textFieldPhone.setText(null);
        }
        if (checkInfo.isPasswordsEqual(Arrays.toString(passwordField.getPassword()), textFieldPassword.getText())) {
            sw[7] = true;
            passwordField.setText(null);
            textFieldPassword.setText(null);
        }

        for (boolean s : sw ){
            if (s) return false;
        }
        return true;

    }

    public SignUp() {
        logInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        this.setContentPane(panel);
        this.setMinimumSize(new Dimension(700,500));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logInButton){
            this.dispose();
            new LogIn();
        } else if (e.getSource()==signUpButton) {
            if (checkInformation()){
                if ((Objects.requireNonNull(comboBoxRole.getSelectedItem())).toString().equalsIgnoreCase("Student")){
                    Student student=new Student(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldEmail.getText()
                            ,textFieldPhone.getText(),textFieldPassword.getText(),textFieldMajor.getText(),textFieldId.getText());
                    student.screen();
                } else if ((Objects.requireNonNull(comboBoxRole.getSelectedItem())).toString().equalsIgnoreCase("Teacher")){
                    Teacher teacher=new Teacher(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldEmail.getText()
                            ,textFieldPhone.getText(),textFieldPassword.getText(),textFieldMajor.getText(),textFieldId.getText());
                    this.dispose();
                    teacher.screen();
                }else if ((Objects.requireNonNull(comboBoxRole.getSelectedItem())).toString().equalsIgnoreCase("Crew")){
                    Crew crew=new Crew(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldEmail.getText()
                            ,textFieldPhone.getText(),textFieldPassword.getText(),textFieldMajor.getText(),textFieldId.getText());
                }
            }
        }

    }
}
