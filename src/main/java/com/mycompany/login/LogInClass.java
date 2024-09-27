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
    if (username.length() < 5 && username.contains("_")) {
        System.out.print
        system.out.print ("Username is not correctly formatted, please ensure than 
                your username contains an underscore and is no more than 5 characters in length);
        return false;
    }
    else 
    // Check if the username contains any invalid characters (except underscore)
    
    
    // If all conditions are met, the username is valid
    return true;
}
}
