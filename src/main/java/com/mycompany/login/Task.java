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
            taskNumber[taskCount] = taskCount + 1;  // Assign task number

            taskCount++;  // Increment the task counter
       
        }
    }
    
            // Method to validate developer's details
        public boolean validateDeveloperDetails(String developerDetails) {
            String[] nameParts = developerDetails.trim().split(" ");
    
        if (nameParts.length < 2) {
            JOptionPane.showMessageDialog(null, "Please enter both first and last name.");
            return false;
        }
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
            //Part 3!!!
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
            
           
            // Display tasks with status "Done"
            public void displayDoneTasks() {
                StringBuilder doneTasks = new StringBuilder("Tasks marked as Done:\n");
                for (int i = 0; i < taskCount; i++) {
                    if ("Done".equals(taskStatus[i])) {
                        doneTasks.append("Developer: ").append(developerDetails[i]).append(" \n")
                                .append(", Task: ").append(taskName[i]).append("\n")
                                .append(", Duration: ").append(taskDuration[i]).append(" hours\n");
                    }
                }
                JOptionPane.showMessageDialog(null, doneTasks.toString());
            }

            // Method to display the developer and duration of the task with the longest duration
            public void displayLongestTask() {
                if (taskCount == 0) {
                    JOptionPane.showMessageDialog(null, "No tasks available.");
                    return; // Exit if no tasks have been added
                }

                int maxDurationIndex = 0; // Index of the task with the longest duration
                for (int i = 1; i < taskCount; i++) {
                    if (taskDuration[i] > taskDuration[maxDurationIndex]) {
                        maxDurationIndex = i; // Update the index for the longest task
                    }
                }

                // Display the details of the task with the longest duration
                JOptionPane.showMessageDialog(null, 
                    "Developer: " + developerDetails[maxDurationIndex] + "\n" +
                    "Task Duration: " + taskDuration[maxDurationIndex] + " hours",
                    "Task with Longest Duration", JOptionPane.INFORMATION_MESSAGE
                );
            }

            // Search by task name
            public void searchByTaskName(String name) {
                for (int i = 0; i < taskCount; i++) {
                    if (taskName[i].equalsIgnoreCase(name)) {
                        JOptionPane.showMessageDialog(null, "Task: " + taskName[i] + "\n" +
                                ", Developer: " + developerDetails[i] + "\n" +
                                ", Status: " + taskStatus[i]);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Task not found.");
            }

            // Search by developer
                        public void searchByDeveloper(String developerName) {
        for (int i = 0; i < taskCount; i++) {
            if (developerDetails[i].equalsIgnoreCase(developerName)) { // Check against developer details
                JOptionPane.showMessageDialog(null, 
                    "Developer: " + developerDetails[i] + "\n" +
                    "Task Name: " + taskName[i] + "\n" +
                    "Status: " + taskStatus[i]);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Developer not found.");
    }

            // Delete a task by name
                public void deleteTask(String name) {
         boolean taskFound = false;
         for (int i = 0; i < taskCount; i++) {
             if (taskName[i].equalsIgnoreCase(name)) { // Correct array reference
                 taskFound = true;

                 // Shift element to the left to remove the task
                 for (int j = i; j < taskCount - 1; j++) {
                     taskName[j] = taskName[j + 1];
                     developerDetails[j] = developerDetails[j + 1];
                     taskDuration[j] = taskDuration[j + 1];
                     taskID[j] = taskID[j + 1];
                     taskStatus[j] = taskStatus[j + 1];
                 }

                 // Clear the last task since it has been shifted
                 taskName[taskCount - 1] = null;
                 developerDetails[taskCount - 1] = null;
                 taskDuration[taskCount - 1] = 0;
                 taskID[taskCount - 1] = null;
                 taskStatus[taskCount - 1] = null;

                 taskCount--; // Decrement the task count
                 JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                 return;
             }
         }

         if (!taskFound) {
             JOptionPane.showMessageDialog(null, "Task not found.");
         }
}


            // Display full report of tasks
            public void displayFullReport() {
                StringBuilder report = new StringBuilder("Full Task Report:\n");
                for (int i = 0; i < taskCount; i++) {
                    report.append("Status: ").append(taskStatus[i]).append("\n")
                            .append("Developer: ").append(developerDetails[i]).append("\n")
                            .append("Number: ").append(taskNumber[i]).append("\n")
                            .append("Task: ").append(taskName[i]).append("\n") 
                            .append("Task ID: ").append(taskID[i]).append("\n")
                            .append("Duration: ").append(taskDuration[i]).append("\n")
                            .append("---------------------------\n"); // Divider for tasks;
                }
                JOptionPane.showMessageDialog(null, "Total hours for all tasks is " + totalHours);
                JOptionPane.showMessageDialog(null, report.toString());
            }
        }
       
    
