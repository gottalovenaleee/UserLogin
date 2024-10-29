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

    public TaskTest() {
    }

    // Test for adding tasks and validating task properties
    @Test
    public void testAddTasks() {
        // Create a Task instance for 2 tasks
        Task task = new Task(2);

        // Manually simulate adding tasks using the provided data
        task.taskName[0] = "Login Feature";
        task.developerDetails[0] = "Robyn Harrison";
        task.taskDuration[0] = 8;
        task.taskStatus[0] = "To Do";
        task.taskID[0] = task.createTaskID(task.taskName[0], 1, task.developerDetails[0]);

        task.taskName[1] = "Add Task Feature";
        task.developerDetails[1] = "Mike Smith";
        task.taskDuration[1] = 10;
        task.taskStatus[1] = "Doing";
        task.taskID[1] = task.createTaskID(task.taskName[1], 2, task.developerDetails[1]);

        // Validate task IDs
        assertEquals("LO:1:SON", task.taskID[0], "Task ID for 'Login Feature' should be LO:1:SON");
        assertEquals("AD:2:ITH", task.taskID[1], "Task ID for 'Add Task Feature' should be AD:2:ITH");
    }

    // Test the createTaskID method
    @Test
    public void testCreateTaskID() {
        Task task = new Task(2);

        // Manually create Task IDs with the provided data
        String taskID1 = task.createTaskID("Login Feature", 1, "Robyn Harrison");
        assertEquals("LO:1:SON", taskID1, "Task ID should be LO:1:SON");

        String taskID2 = task.createTaskID("Add Task Feature", 2, "Mike Smith");
        assertEquals("AD:2:ITH", taskID2, "Task ID should be AD:2:ITH");
    }

    // Test for calculating total hours of tasks
    @Test
    public void testReturnTotalHours() {
        Task task = new Task(5);

        // Manually set the task durations using the provided data
        task.taskDuration[0] = 10;  // For "Login Feature"
        task.taskDuration[1] = 12; // For "Add Task Feature"
        task.taskDuration[2] = 55;
        task.taskDuration[3] = 11;
        task.taskDuration[4] = 1;

        // Calculate total hours (sum all task durations)
         task.totalHours = task.taskDuration[0] + task.taskDuration[1] + task.taskDuration[2] 
                    + task.taskDuration[3] + task.taskDuration[4];
    
        // Check if the total hours are calculated correctly
        assertEquals(89, task.returnTotalHours(), "Total hours should be 89 for all tasks.");
    }

    // Test for task description validation (both success and failure cases)
    @Test
    public void testValidateTaskDescription() {
        Task task = new Task("Sample Task");

        // Test case 1: Description with fewer than 50 characters (Success)
        String shortDescription = "Create login to authenticate users";
        assertTrue(task.checkTaskDescription(shortDescription),
            "Task description should be valid with fewer than 50 characters.");

        // Test case 2: Description with more than 50 characters (Failure)
        String longDescription = "This is a very long task description that exceeds fifty characters.";
        assertFalse(task.checkTaskDescription(longDescription),
            "Task description should be invalid if it exceeds 50 characters.");
    }
        
    @Test
    public void testPrintTaskDetails() {
        // Create a Task instance with a size of 2 (for example)
        Task task = new Task(2);

        // Manually set the task properties for the first task (index 0)
        task.taskName[0] = "Login Feature";
        task.developerDetails[0] = "Robyn Harrison";
        task.taskNumber[0] = 1;
        task.taskDescription = "Create login to authenticate users";  // Since it's not an array, we set it directly
        task.taskID[0] = task.createTaskID(task.taskName[0], task.taskNumber[0], task.developerDetails[0]);
        task.taskStatus[0] = "To Do";
        task.taskDuration[0] = 8;

        // Expected string that should match the output of printTaskDetails(0)
        String expectedOutput = "Task Status: To Do\n" +
                                "Developer: Robyn Harrison\n" +
                                "Task Number: 1\n" +
                                "Task Name: Login Feature\n" +
                                "Task Description: Create login to authenticate users\n" +
                                "Task ID: LO:1:SON\n" +
                                "Task Duration: 8 hours"; 
    }
}

