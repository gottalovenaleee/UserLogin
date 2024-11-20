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
        assertEquals("LO:1:ROB", taskID1, "Task ID should be LO:1:ROB");

        // Test case 2
        String taskID2 = task.createTaskID("Add Task Feature", 2, "Mike Smith");
        assertEquals("AD:2:MIK", taskID2, "Task ID should be AD:2:MIK");
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
        assertEquals("LO:1:ROB", task.taskID[0], "Task ID should match.");
    }
    
    @Test
    public void testPopulateDeveloperArray() {
        Task task = new Task(3); // Assuming we want to populate an array of size 3

        // Simulate populating the array
        String[] developers = {"Alice Johnson", "Bob Smith", "Carol Lee"};
        task.developerDetails = developers; // Populate the array

        // Validate that the array is populated correctly
        assertEquals("Alice Johnson", task.developerDetails[0], "First developer should be Alice Johnson.");
        assertEquals("Bob Smith", task.developerDetails[1], "Second developer should be Bob Smith.");
        assertEquals("Carol Lee", task.developerDetails[2], "Third developer should be Carol Lee.");

        // Additional checks for array size and non-null elements
        assertEquals(3, task.developerDetails.length, "Developer array size should be 3.");
        for (String developer : task.developerDetails) {
            assertNotNull(developer, "Developer details should not be null.");
        }
    }
    @Test
    public void testSearchByTaskName() {
        Task task = new Task(3); // Initialize Task with array size 3

        // Populate task array
        task.taskName[0] = "Login Feature";
        task.taskName[1] = "Create Report";
        task.taskName[2] = "Add Task Feature";

        task.developerDetails[0] = "Alice Johnson";
        task.developerDetails[1] = "Bob Smith";
        task.developerDetails[2] = "Carol Lee";

        task.taskStatus[0] = "To Do";
        task.taskStatus[1] = "Doing";
        task.taskStatus[2] = "Done";
    }
    @Test
    public void testSearchByDeveloper() {
        Task task = new Task(3); // Initialize Task with array size 3

        // Populate developer and task arrays
        task.taskName[0] = "Login Feature";
        task.taskName[1] = "Create Report";
        task.taskName[2] = "Add Task Feature";

        task.developerDetails[0] = "Alice Johnson";
        task.developerDetails[1] = "Bob Smith";
        task.developerDetails[2] = "Carol Lee";

        task.taskStatus[0] = "To Do";
        task.taskStatus[1] = "Doing";
        task.taskStatus[2] = "Done";
          }

    
         @Test
    public void testDisplayDoneTasks() {
        Task task = new Task(2);

        // Add tasks
        task.taskName[0] = "Task One";
        task.taskStatus[0] = "Done";
        task.developerDetails[0] = "Dev A";
        task.taskDuration[0] = 3;

        task.taskName[1] = "Task Two";
        task.taskStatus[1] = "To Do";
        task.developerDetails[1] = "Dev B";
        task.taskDuration[1] = 5;

        // Test the "Done" tasks
        StringBuilder doneTasks = new StringBuilder();
        for (int i = 0; i < task.taskCount; i++) {
            if ("Done".equals(task.taskStatus[i])) {
                doneTasks.append(task.taskName[i]).append(" completed by ").append(task.developerDetails[i]).append("\n");
            }
        }

        assertTrue(doneTasks.toString().contains("Task One completed by Dev A"), "Done tasks should include 'Task One'.");
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task(3);

        // Add tasks
        task.taskName[0] = "Task One";
        task.taskName[1] = "Task Two";
        task.taskName[2] = "Task Three";
        task.taskCount = 3;

        // Delete Task Two
        task.deleteTask("Task Two");

        // Validate the deletion
        assertNull(task.taskName[1], "Task Two should be deleted.");
        assertEquals("Task Three", task.taskName[1], "Task Three should shift to position 1.");
    }

    @Test
    public void testLongestTask() {
        Task task = new Task(3);

        // Add tasks with varying durations
        task.taskDuration[0] = 4;
        task.taskDuration[1] = 7;
        task.taskDuration[2] = 3;
        task.taskCount = 3;

        // Find the longest task
        int longestDurationIndex = 0;
        for (int i = 1; i < task.taskCount; i++) {
            if (task.taskDuration[i] > task.taskDuration[longestDurationIndex]) {
                longestDurationIndex = i;
            }
        }

        assertEquals(1, longestDurationIndex, "Longest task should be at index 1.");
        assertEquals(7, task.taskDuration[longestDurationIndex], "Longest task duration should be 7.");
    }
   }
