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
    public boolean isValidUsername(String username) {
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

}
 
