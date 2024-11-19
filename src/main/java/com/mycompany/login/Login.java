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
        String fname, lname, username, password;
        
         final JDialog dialog = new JDialog();
         dialog.setAlwaysOnTop(true);
        
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter first name, last name, username, and password
        System.out.println("WELCOME");
        System.out.print("Enter first name: ");
        fname = scanner.nextLine();
        System.out.print("Enter last name: ");
        lname = scanner.nextLine();
        System.out.print("Enter username: ");
        username = scanner.nextLine();

        // Create an instance of LogInClass to call non-static methods
        LogInClass logInClass = new LogInClass();
        
        // Loop until a valid password is entered
        String registrationMessage = "";
        while (true) {
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Check password complexity
            if (!checkPasswordComplexity(password)) {
                System.out.println("Invalid password. Please try again.");
                continue; // Prompt for password again if it does not meet requirements
            }

            // Register the user using the provided username and password
            registrationMessage = logInClass.registerUser(username, password, lname, fname);
            System.out.println(registrationMessage);

            // If registration is successful, break out of the loop
            if ("User successfully registered.".equals(registrationMessage)) {
                break;
            }
        }

        // Loop until the user enters the correct username and password
        boolean loggedIn = false;
        while (!loggedIn) {
            // Prompt the user to enter their username and password for login
            System.out.print("Enter your Username to login: ");
            String loginUserName = scanner.nextLine();
            System.out.print("Enter your Password to login: ");
            String loginPassword = scanner.nextLine();

            // Call the returnLoginStatus method to check login
            String loginStatus = logInClass.returnLoginStatus(fname, lname, username, loginPassword);
            System.out.println(loginStatus);
             
            // Check if login was successful
            if ("Login successful".equals(loginStatus)) {
                loggedIn = true; // Exit loop on successful login
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            } else {
                System.out.println("Invalid login credentials. Please try again.");
            }
        }

        // Menu for additional actions
            boolean running = true;
            while (running) {
                String[] options = {
                    "Add tasks /n",
                    "Show longest task",
                    "Search by task name",
                    "Search by developer",
                    "Delete a task",
                    "Show full report",
                    "Show 'Done' tasks",
                    "Quit"
                };

       
        // Ask user how many tasks they want to add
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        Task task = new Task(numberOfTasks); // Create Task object to hold the tasks
        task.addTasks(numberOfTasks); // Add tasks

        // Menu for additional actions
               while (running) {
                   int option = JOptionPane.showOptionDialog(null, "Please select an option:", "EasyKanban Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0: // Add tasks
                    numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many additional tasks would you like to add?"));
                    task.addTasks(numberOfTasks);
                    break;
                case 1: // Show the task with the longest duration
                task.displayLongestTask();
                break;

            case 2: // Search by task name
                String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
                task.searchByTaskName(taskName);
                break;

            case 3: // Search by developer
                String developerName = JOptionPane.showInputDialog("Enter the developer's name to search:");
                task.searchByDeveloper(developerName);
                break;

            case 4: // Delete a task
                String taskToDelete = JOptionPane.showInputDialog("Enter the name of the task to delete:");
                task.deleteTask(taskToDelete);
                break;

            case 5: // Show full report
                task.displayFullReport();
                break;

            case 6: //Show 'Done' tasks
                task.displayDoneTasks();
                 break;
            case 7: // Quit
                JOptionPane.showMessageDialog(null, "Goodbye!");
                running = false;
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid option selected.");
                break;
        }
                   
            }
        }
    }
}