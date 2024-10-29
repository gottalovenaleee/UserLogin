/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */

public class Task {
    // Declare the arrays for task properties
    String[] taskName;
    int[] taskNumber;
    String[] developerDetails;
    int[] taskDuration;
    String[] taskID;
    String[] taskStatus;
    int totalHours;  // Declare total hours
    int taskCount;   // Track the number of tasks added
    String taskDescription; // Single task description

    // Constructor to initialize the arrays and variables
    public Task(int size) {
        // Initialize the arrays with the given size
        this.taskName = new String[size];
        this.taskNumber = new int[size];
        this.developerDetails = new String[size];
        this.taskDuration = new int[size];
        this.taskID = new String[size];
        this.taskStatus = new String[size];
        this.totalHours = 0; // Initialize totalHours
        this.taskCount = 0;  // Initialize taskCount
    }
    
    // Constructor to initialize taskDescription
    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    // Method to add tasks
    public void addTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            taskName[taskCount] = JOptionPane.showInputDialog("Enter the name of task " + (taskCount + 1) + ":");
            
            // Loop until a valid task description is entered
            do {
                taskDescription = JOptionPane.showInputDialog("Enter the description for task " + (taskCount + 1) + " (less than 50 characters):");
            } while (!checkTaskDescription(taskDescription));  // Will loop until a valid description is entered
            
            // Loop until a correct develop details is entered
             developerDetails[taskCount] = JOptionPane.showInputDialog("Enter the developer's details for task " + (taskCount + 1) + " (first and last name):");
            while (!validateDeveloperDetails(developerDetails[taskCount])) {
                developerDetails[taskCount] = JOptionPane.showInputDialog("Enter the developer's details for task " + (taskCount + 1) + " (first and last name):");
            }
            taskDuration[taskCount] = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration for task " + (taskCount + 1) + " (in hours):"));

            taskID[taskCount] = createTaskID(taskName[taskCount], taskCount + 1, developerDetails[taskCount]);
            String[] options = {"To Do", "Doing", "Done"};
             taskStatus[taskCount] = (String) JOptionPane.showInputDialog(
             null, 
             "Select the status for task " + (taskCount + 1) + ":", 
             "Task Status", 
             JOptionPane.QUESTION_MESSAGE, 
             null, 
             options, 
             options[0]
         );


            totalHours += taskDuration[taskCount];  // Add to total hours
            taskNumber[taskCount] = taskCount ;  // Assign task number

            taskCount++;  // Increment the task counter
            
        //Calling The pring taks details
         JOptionPane.showMessageDialog(null,printTaskDetails(i));

        
            
        }
        
        JOptionPane.showMessageDialog(null, "Total hours for all tasks is " + totalHours);
                    }
    
            // Method to validate developer's details
        public boolean validateDeveloperDetails(String developerDetails) {
            String[] nameParts = developerDetails.trim().split(" ");
    
        if (nameParts.length < 2) {
            JOptionPane.showMessageDialog(null, "Please enter both first and last name.");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Developer's details successfully captured.");
    return true;
     }
         // Method to check if task description length is less than 50 characters
        public boolean checkTaskDescription(String taskDescription) {
            if (taskDescription == null) {
                return false; // Handle null task description
            }

            // Get the length of the task description
            int descriptionLength = taskDescription.length();
           return taskDescription.length()<= 50;
}

        // Method to create task ID
        public String createTaskID(String taskName, int taskNumber, String developerDetails) {
            String[] devNameParts = developerDetails.split(" ");
            String devLastName = devNameParts[1];  // Assuming name has at least two parts
            return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + devLastName.substring(devLastName.length() - 3).toUpperCase();
        }

            // Method to display tasks in detail
        public String printTaskDetails(int details) {
            return "Task Details of "+ developerDetails[details] +":\n" +  //Heading
                    "Task Status: " + taskStatus[details]+ "\n" +
                    "Developer Details: " + developerDetails[details] + "\n" +
                    "Task Number: " + taskNumber[details] + "\n" +
                    "Task Name: " + taskName[details] + "\n" +
                    "Task Description: " + taskDescription + "\n" +
                    "Task ID: " + taskID[details] + "\n" +
                    "Task Duration: " + taskDuration[details] + " hours";
        }


            // Method to return total hours of all tasks
            public int returnTotalHours() {
                return totalHours;
            }
    }
