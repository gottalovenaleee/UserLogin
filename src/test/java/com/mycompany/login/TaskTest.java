/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
 package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {

    @Test
    public void testCreateTaskID() {
        Task task = new Task(1);

        // Test case 1
        String taskID1 = task.createTaskID("Login Feature", 1, "Robyn Harrison");
        assertEquals("LO:1:SON", taskID1, "Task ID should be LO:1:SON");

        // Test case 2
        String taskID2 = task.createTaskID("Add Task Feature", 2, "Mike Smith");
        assertEquals("AD:2:ITH", taskID2, "Task ID should be AD:2:ITH");
    }

    @Test
    public void testValidateDeveloperDetails() {
        Task task = new Task(1);

        // Valid developer details
        assertTrue(task.validateDeveloperDetails("John Doe"), "Valid developer details should return true.");

        // Invalid developer details (missing last name)
        assertFalse(task.validateDeveloperDetails("John"), "Developer details missing last name should return false.");
    }

    @Test
    public void testCheckTaskDescription() {
        Task task = new Task("");

        // Valid task description
        assertTrue(task.checkTaskDescription("Complete login module"), "Valid task description should return true.");

        // Invalid task description (too long)
        assertFalse(task.checkTaskDescription("This is a very long task description that exceeds fifty characters."),
                "Task description exceeding 50 characters should return false.");
    }

    @Test
    public void testAddTasks() {
        Task task = new Task(2);

        // Mocking task addition
        task.taskName[0] = "Login Feature";
        task.developerDetails[0] = "Robyn Harrison";
        task.taskDuration[0] = 5;
        task.taskStatus[0] = "To Do";
        task.taskID[0] = task.createTaskID("Login Feature", 1, "Robyn Harrison");
        task.taskCount++;

        // Validate the task added
        assertEquals("Login Feature", task.taskName[0], "Task name should match.");
        assertEquals("Robyn Harrison", task.developerDetails[0], "Developer details should match.");
        assertEquals(5, task.taskDuration[0], "Task duration should match.");
        assertEquals("To Do", task.taskStatus[0], "Task status should match.");
        assertEquals("LO:1:SON", task.taskID[0], "Task ID should match.");
    }
    
      @Test
    public void testPopulateDeveloperArray() {
        Task task = new Task(4); // Initialize Task with array size 4

        // Populate developer details
        String[] developers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        task.developerDetails = developers; // Populate the array

        // Validate that the array is populated correctly
        assertEquals("Mike Smith", task.developerDetails[0], "First developer should be Mike Smith.");
        assertEquals("Edward Harrison", task.developerDetails[1], "Second developer should be Edward Harrison.");
        assertEquals("Samantha Paulson", task.developerDetails[2], "Third developer should be Samantha Paulson.");
        assertEquals("Glenda Oberholzer", task.developerDetails[3], "Fourth developer should be Glenda Oberholzer.");

        // Additional checks for array size and non-null elements
        assertEquals(4, task.developerDetails.length, "Developer array size should be 4.");
        for (String developer : task.developerDetails) {
            assertNotNull(developer, "Developer details should not be null.");
        }
    }
        @Test
    public void testLongestTask() {
        Task task = new Task(4);

        // Add tasks with durations
        task.taskName[0] = "Create Login";
        task.taskDuration[0] = 5;
        task.taskName[1] = "Add Feature";
        task.taskDuration[1] = 8;
        task.taskName[2] = "Create Reports";
        task.taskDuration[2] = 2;
        task.taskName[3] = "Add Arrays";
        task.taskDuration[3] = 11;
        
         // Update taskCount to reflect the number of tasks (if you're not using dynamic task count)
         task.taskCount = 4;

        // Find the longest task
        int longestTaskIndex = 0;
        for (int i = 1; i < task.taskCount; i++) {
            if (task.taskDuration[i] > task.taskDuration[longestTaskIndex]) {
                longestTaskIndex = i;
            }
        }

        assertEquals("Add Arrays", task.taskName[longestTaskIndex], "Longest task should be 'Add Arrays'.");
        assertEquals(11, task.taskDuration[longestTaskIndex], "Longest task duration should be 11.");
    }
   
    @Test
    public void testSearchByTaskName() {
        Task task = new Task(4); // Initialize Task with array size 4

        // Populate task array
        task.taskName[0] = "Create Login";
        task.taskName[1] = "Add Feature";
        task.taskName[2] = "Create Reports";
        task.taskName[3] = "Add Arrays";

        task.developerDetails[0] = "Mike Smith";
        task.developerDetails[1] = "Edward Harrison";
        task.developerDetails[2] = "Samantha Paulson";
        task.developerDetails[3] = "Glenda Oberholzer";

        task.taskStatus[0] = "To Do";
        task.taskStatus[1] = "Doing";
        task.taskStatus[2] = "Done";
        task.taskStatus[3] = "To Do";

        // Test searching for a specific task name
        String taskNameToSearch = "Create Reports";
        boolean found = false;

        for (int i = 0; i < task.taskName.length; i++) {
            if (task.taskName[i].equalsIgnoreCase(taskNameToSearch)) {
                found = true;
                assertEquals("Create Reports", task.taskName[i], "Task name should match.");
                assertEquals("Samantha Paulson", task.developerDetails[i], "Developer should match.");
                assertEquals("Done", task.taskStatus[i], "Task status should match.");
            }
        }
        assertTrue(found, "Task should be found.");
    }

    @Test
    public void testSearchByDeveloper() {
        Task task = new Task(4); // Initialize Task with array size 4

        // Populate developer and task arrays
        task.taskName[0] = "Create Login";
        task.taskName[1] = "Add Feature";
        task.taskName[2] = "Create Reports";
        task.taskName[3] = "Add Arrays";

        task.developerDetails[0] = "Mike Smith";
        task.developerDetails[1] = "Edward Harrison";
        task.developerDetails[2] = "Samantha Paulson";
        task.developerDetails[3] = "Glenda Oberholzer";

        task.taskStatus[0] = "To Do";
        task.taskStatus[1] = "Doing";
        task.taskStatus[2] = "Done";
        task.taskStatus[3] = "To Do";

        // Test searching for a specific developer
        String developerToSearch = "Edward Harrison";
        boolean found = false;

        for (int i = 0; i < task.developerDetails.length; i++) {
            if (task.developerDetails[i].equalsIgnoreCase(developerToSearch)) {
                found = true;
                assertEquals("Add Feature", task.taskName[i], "Task name should match for the developer.");
                assertEquals("Doing", task.taskStatus[i], "Task status should match for the developer.");
            }
        }
        assertTrue(found, "Developer should be found.");
    }

}
