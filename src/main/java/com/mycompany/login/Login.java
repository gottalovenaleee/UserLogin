/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {

    public static void main(String[] args) {
        //Declarations
    String fname, lname, username, password;
    // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
   // Prompt user to enter first name, last name, username, and password
        
        System.out.print("Enter first name: ");
            fname = scanner.nextLine();
        System.out.print("Enter last name: ");
            lname = scanner.nextLine();
        System.out.print("Enter username: ");
             username = scanner.nextLine();
        System.out.print("Enter password: ");
            password = scanner.nextLine();
         // Create an instance of LogInClass
        LogInClass logInClass = new LogInClass(fname, lname, username, password);

        // Call the registerUser method
        LogInClass.registerUser(fname, lname, username, password);

        // Call the loginUser method
        System.out.print("Enter username: ");
           String LoginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
           String LoginPassword = scanner.nextLine();
        LogInClass.loginUser(username, password);

        // Call the returnLoginStatus method
        String loginStatus = LogInClass.returnLoginStatus(username, password, fname, lname);
        System.out.println(loginStatus);
        
    }
}   
            


    

