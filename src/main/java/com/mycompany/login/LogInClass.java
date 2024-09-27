/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author RC_Student_lab
 */
public class LogInClass { //static map to store usernames and passwords for registered users
    private static Map<String, String > userDatabase = new HashMap<>();

    private String fname;
    private String lname;
    private String username;
    private String password;

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
    if (username.length() > 5 || !username.contains("_")) {
        return false;
    }
    else {
        return true;
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
                
           public static String registerUser(String usrname, String Password) { //register a username and password
            userDatabase.put(username, password);
            System.out.println("User registered successfully!");
           username = "nale_"; // example username
            if (checkUserName(username)){
                System.out.println("Username succesfully captured");
         } else{
                System.out.print("Username is not correctly formatted,please ensure than your username contains an underscore and is no more than 5 characters in length");
        // If all conditions are met, the username is valid 
            }
       
             password = "Naledi@16";  // example password
        if (checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains atleast 8 characters,a capital letter, a number and a special character");
        } else {
            System.out.println("Password succesfully captured");
            return password;
            }
           }
           //Testing login
            System.out.println(returnLogStatus(username, password));
            
         //Check  username & display user friendly

         public static boolean loginUser (String username, String password){
         if (checkUserName){
             System.out.print("Username successfully captured");
         } else{
             System.out.print("Username is not correctly formatted,please ensure than your username contains an underscore and is no more than 5 characters in length");
                     }
         if (checkPasswordComplexity){
         }
         public static String returnLoginStatus (String username, String password){
         //Check if the login details are correct
         if (loginUser(username, password)){
         }     
}
}
}     
        
           
        
   /**public String registerUser() {
       if username && password = true;
       System.out.print("Welcome" + fname + "," + lname + "it's great to see you again");
       else System.out.print("Username or password incorrect, please try again")
       
        return ;
       
       
       
   }
   
}* **/
 
