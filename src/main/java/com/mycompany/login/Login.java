/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import static com.mycompany.login.LogInClass.checkPasswordComplexity;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class Login {

    public static void main(String[] args) {
        // Declarations
        String fname, lname, username, password, statusText = null;
      
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        
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
        System.out.println(" ");

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
            LogInClass logInClass = new LogInClass();

            // Call the registerUser method
            String registrationStatus = LogInClass.registerUser(username, password);
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
                 JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                
            }else{
                if (loggedIn = false){
                    break;
                }
            }
        }
        // Ask user how many tasks they want to add
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        Task task = new Task(numberOfTasks); // Create Task object to hold the tasks

        // Add tasks
        task.addTasks(numberOfTasks);

        // Menu for additional actions
        boolean running = true;
        while (running) {
            String[] options = {"1) Add tasks", "2) Show report", "3) Quit"};
            int option = JOptionPane.showOptionDialog(null, "Please select an option:", "EasyKanban Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0: // Add tasks
                    numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many additional tasks would you like to add?"));
                    task.addTasks(numberOfTasks);
                    break;
                case 1: // Show report
                    JOptionPane.showMessageDialog(null,"Coming soon!");
                    break;
                case 2: // Quit
                    JOptionPane.showMessageDialog(null,"Goodbye!");
                    running = false; // Exit the loop to quit
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option selected.");
                    
                    dialog.dispose();
            }
        }
    }
}