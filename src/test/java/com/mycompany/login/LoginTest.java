/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        // Initialize Task with a size of 5 (for testing purposes)
        task = new Task(5);
    }

    @org.junit.jupiter.api.Test
    public void testAddTasks() {
        // Simulate adding tasks (without user input)
        task.taskName[0] = "Login Feature";
        task.taskDescription[0] = "Create login to authenicate users ";
        task.developerDetails[0] = "Robyn Harrison";
        task.taskDuration[0] = 8;
        task.taskID[0] = task.createTaskID(task.taskName[0], 1, task.developerDetails[0]);
        task.taskStatus[0] = "To Do";
        task.taskNumber[0] = 1;
        task.totalHours += 8;
        task.taskCount++;

        // Assertions to check if the tasks were added correctly
        assertEquals("Login Feature", task.taskName[0]);
        assertEquals("Create login to authenicate users", task.taskDescription[0]);
        assertEquals("Robyn Harrison", task.developerDetails[0]);
        assertEquals(8, task.taskDuration[0]);
        assertEquals("LF:1:SON", task.taskID[0]);
        assertEquals("To Do", task.taskStatus[0]);
        assertEquals(1, task.taskNumber[0]);
        assertEquals(8, task.totalHours);
    }

    @Test
    public void testCreateTaskID() {
        // Test ID creation
        String taskName = "DevelopApp";
        String developer = "John Doe";
        String taskID = task.createTaskID(taskName, 1, developer);
        assertEquals("DE:1:DOE", taskID);
    }

    @Test
    public void testReturnTotalHours() {
        // Test total hours calculation
        task.totalHours = 10;  // Set some hours manually
        assertEquals(10, task.returnTotalHours());
    }
}
