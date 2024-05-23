package LogInSignUp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInfo {
    public boolean isEmailValid(String email){
        String pattern = "^[.a-zA-Z0-9]+@[-.a-zA-Z0-9]+[a-z]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);
        if (email.length()>31) return false;
        else return matcher.matches();
    }
    public boolean isPhoneNumValid(String phoneNum){
        if (phoneNum.length()!=11) return false;
        String pattern = "^09\\d{9}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phoneNum);
        return matcher.matches();
    }

    //firstname - lastname - major
    public boolean isNameValid(String originalName){
        if(originalName.length()>18) return true;
        String name = originalName.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i)<'a' || name.charAt(i)>'z'){
                if (name.charAt(i)!=' ') return true;
            }
        }
        return false;
    }

    public boolean isUsernameValid(String username){
        //if(username.length()>12 || username.length()<5) return false;
        String pattern = "^[a-zA-Z0-9]{5,12}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(username);
        return matcher.matches();
    }
    public boolean isPasswordValid(String password){
        if(password.length()>12 || password.length()<8) return true;
        String pattern = "^[a-zA-Z0-9]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(password);
        return !matcher.matches();
    }
    public boolean isPasswordsEqual(String password,String password2){
        if (isPasswordValid(password) && isPasswordValid(password2)) {
            return password.equals(password2);
        }
        return false;
    }
    public boolean isIdValidE(String id , String role)throws InvalidIDException{
        Pattern regex;
        Matcher matcher;
        try {
            if (role.equalsIgnoreCase("student")){
            regex = Pattern.compile("^\\d{10}");
            matcher = regex.matcher(id);
            matcher.matches();
        }
        else if (role.equalsIgnoreCase("teacher")){
            regex = Pattern.compile("^\\d{6}");
            matcher = regex.matcher(id);
            matcher.matches();
        }
        else if (role.equalsIgnoreCase("crew")){
            regex = Pattern.compile("^\\d{4}");
            matcher = regex.matcher(id);
            matcher.matches();
        }
        } catch (InvalidIDException e){
            e.getMessage();
            return false;
        }
        return true;
    }

//    public boolean isIdValid(String id , String role){
////        Pattern regex;
////        Matcher matcher;
////        if (role.equalsIgnoreCase("student")){
////            regex = Pattern.compile("^\\d{10}");
////            matcher = regex.matcher(id);
////            return matcher.matches();
////        }
////        else if (role.equalsIgnoreCase("teacher")){
////            regex = Pattern.compile("^\\d{6}");
////            matcher = regex.matcher(id);
////            return matcher.matches();
////        }
////        else if (role.equalsIgnoreCase("crew")){
////            regex = Pattern.compile("^\\d{4}");
////            matcher = regex.matcher(id);
////            return matcher.matches();
////        }
//        isIdValidE(id,role);
//        return false;
//    }
    public boolean isIdValid(String id) {
        Pattern regex;
        Matcher matcher;
        regex = Pattern.compile("^\\d{10}|^\\d{6}|^\\d{4}");
        matcher = regex.matcher(id);
        return matcher.matches();
    }

}
