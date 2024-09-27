/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
/**
 *
 * @author RC_Student_lab
 */
public class LogInClass { 
    public String fname;
    public String lname;
    public String username;
    public String password;

    // Constructor to initialize
    public LogInClass (String fname, String lname, String username, String password) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }
    //Check if username and password meets the requirements
    public static boolean checkUserName(String username) {
    // Check if the username has not more than of 5 characters long and contains any invalid characters (except underscore
    if (username.length() >= 5 && !username.contains("_")) {
        return true;
    }
    else {
        return false;
    }
    }
 public static boolean checkPasswordComplexity (String password){
     if (password.length() < 8) {
                 return false;  // password must be at least 8 characters long
                 
     }

        boolean hasCapitalLetter = false;
        boolean hasLowercaseLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        

        //Make if statements | Nest like if statements

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercaseLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }

            if (hasCapitalLetter && hasLowercaseLetter && hasDigit && hasSpecialCharacter) {
                break;  // all conditions met, no need to continue
            }
        }

        return hasCapitalLetter && hasLowercaseLetter && hasDigit && hasSpecialCharacter;
    }
                
           public static void registerUser(String username, String Password) { //register a username and password
            if (checkUserName(username)){
                System.out.println("Username succesfully captured");
         } else{
                System.out.print("Username is not correctly formatted,please ensure than your username contains an underscore and is no more than 5 characters in length");
        // If all conditions are met, the username is valid 
            }
       if (checkPasswordComplexity(Password)) {
            System.out.println("Password succesfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains atleast 8 characters,a capital letter, a number and a special character");
            }
           }
         //Check  username & display user friendly
           
         public static void loginUser (String username, String password){
         
         if (checkUserName (username)){
             System.out.print("Username successfully captured");
         } else{
             System.out.print("Username is not correctly formatted,please ensure than your username contains an underscore and is no more than 5 characters in length");
                     }
         if (checkPasswordComplexity(password)){
             System.out.print("Login succesful");
         } else{
             System.out.print("Login failed");
                     }
         }
       public static String returnLoginStatus (String fname, String lname, String username, String password){
         //Check if the login details are correct
        if ((checkUserName(username)) && (checkPasswordComplexity(password))){
        System.out.println("Welcome " + fname + ", " + lname + ". It's great to see you again");
        return "Login successful";
        } else {
            System.out.print("Username or password incorrect, please try again");
             return "Login failed";
       
}
}
}     
  