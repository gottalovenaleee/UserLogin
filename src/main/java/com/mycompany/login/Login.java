/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import static com.mycompany.login.LogInClass.checkPasswordComplexity;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {

    public static void main(String[] args) {
        // Declarations
        String fname, lname, username, password;
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter first name, last name, username, and password
        System.out.println("WELCOME");
        System.out.print("Enter first name: ");
        fname = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Enter last name: ");
        lname = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Enter username: "); 
        username = scanner.nextLine();

        // Loop until a valid password is entered
        while (true) {
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Check password complexity
            if (!checkPasswordComplexity(password)) {
                System.out.println("*");
                System.out.println("Invalid password. Please try again.");
                continue; // Prompt for password again if it does not meet requirements
            }

            // Create an instance of LogInClass
            LogInClass logInClass = new LogInClass(fname, lname, username, password);

            // Call the registerUser method
            String registrationStatus = LogInClass.registerUser(fname, lname, username, password);
            System.out.println(registrationStatus);
            break; // Exit loop if registration is successful
        }

        // Loop until the user enters the correct username and password
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("*");
            System.out.print("Enter username for login: ");
            String loginUsername = scanner.nextLine();
            System.out.println("*");
            System.out.print("Enter password for login: ");
            String loginPassword = scanner.nextLine();

            // Call the returnLoginStatus method
            String loginStatus = LogInClass.returnLoginStatus(fname, lname, loginUsername, loginPassword);
            System.out.println(loginStatus);
            
            // Check if login was successful
            if (loginStatus.equals("Login successful")) {
                loggedIn = true; // Exit loop on successful login
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}