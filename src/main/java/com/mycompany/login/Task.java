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
    String[] taskDescription;
    String[] developerDetails;
    int[] taskDuration;
    String[] taskID;
    String[] taskStatus;
    int totalHours = 0; // Declare total hours
    int taskCount = 0;  // Track the number of tasks added

    // Constructor to initialize the arrays
    public Task(int size) {
        taskName = new String[size];
        taskNumber = new int[size];
        taskDescription = new String[size];
        developerDetails = new String[size];
        taskDuration = new int[size];
        taskID = new String[size];
        taskStatus = new String[size];
    }

    // Method to add tasks
    public void addTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            taskName[taskCount] = JOptionPane.showInputDialog("Enter the name of task " + (taskCount + 1) + ":");
            taskDescription[taskCount] = JOptionPane.showInputDialog("Enter the description for task " + (taskCount + 1) + ":");
            developerDetails[taskCount] = JOptionPane.showInputDialog("Enter the developer's name for task " + (taskCount + 1) + ":");
            taskDuration[taskCount] = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration for task " + (taskCount + 1) + " (in hours):"));
            taskID[taskCount] = createTaskID(taskName[taskCount], taskCount + 1, developerDetails[taskCount]);
            taskStatus[taskCount] = JOptionPane.showInputDialog("Enter the status (To Do, Doing, Done) for task " + (taskCount + 1) + ":");

            totalHours += taskDuration[taskCount];  // Add to total hours
            taskNumber[taskCount] = taskCount + 1;  // Assign task number

            taskCount++;  // Increment the task counter
        }
    }

    // Method to display added tasks
    public void displayTasks() {
        StringBuilder taskSummary = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            taskSummary.append("Task ").append(i + 1).append(" Details:\n");
            taskSummary.append("Status: ").append(taskStatus[i]).append("\n");
            taskSummary.append("Developer Details: ").append(developerDetails[i]).append("\n");
            taskSummary.append("Number: ").append(taskNumber[i]).append("\n");
            taskSummary.append("Name: ").append(taskName[i]).append("\n");
            taskSummary.append("Description: ").append(taskDescription[i]).append("\n");
            taskSummary.append("ID: ").append(taskID[i]).append("\n");
            taskSummary.append("Duration: ").append(taskDuration[i]).append(" hours\n\n");
        }

        JOptionPane.showMessageDialog(null, taskSummary.toString());
    }

    // Method to create task ID
    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String[] devNameParts = developerDetails.split(" ");
        String devLastName = devNameParts[1];  // Assuming name has at least two parts
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + devLastName.substring(devLastName.length() - 3).toUpperCase();
    }

    // Method to return total hours of all tasks
    public int returnTotalHours() {
        return totalHours;
    }
}
