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
          // Check if username meets the requirements
    public static boolean checkUserName(String username) {
        // Check if the username is no more than 5 characters long and contains an underscore
        return (username.length() <= 5 && username.contains("_"));
    }

    public static boolean checkPasswordComplexity(String password) {
        // Check for Capital Letter, Digit, and Special Character
        boolean hasCapitalLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        // Check if password must be at least 8 characters long
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false; // Early return if the length check fails
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }

            if (hasCapitalLetter && hasDigit && hasSpecialCharacter) {
                break;  // All conditions met, no need to continue
            }
        }

        return hasCapitalLetter && hasDigit && hasSpecialCharacter;
    }

    public static String registerUser(String fname, String lname, String username, String password) {
        // Register a username and password
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "User registered successfully."; // Indicate success
    }

    // Check username & display user friendly
    public static boolean loginUser(String storedUsername, String storedPassword, String inputUsername, String inputPassword) {
        if (!storedUsername.equals(inputUsername)) {
            System.out.println("Username is not correct.");
            return false;
        }

        if (!storedPassword.equals(inputPassword)) {
            System.out.println("Login failed. Please check your password.");
            return false;
        }

        System.out.println("Login successful.");
        return true;
    }

    public static String returnLoginStatus(String fname, String lname, String username, String password) {
        if (loginUser(username, password, username, password)) {
            System.out.println("Welcome " + fname + " " + lname + ". It's great to see you again!");
            return "Login successful";
        } else {
            System.out.println("Username or password incorrect. Please try again.");
            return "Login failed";
        }
    }
}