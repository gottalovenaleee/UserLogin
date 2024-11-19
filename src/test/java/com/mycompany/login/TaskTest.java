/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
 package com.mycompany.login;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test the createTaskID method to ensure it generates the correct Task ID.
     */
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

    /**
     * Test adding tasks and validating their properties.
     */
    @Test
    public void testAddTasks() {
        // Initialize Task with size 2
        Task task = new Task(2);

        // Manually add first task
        task.getDevelopers()[0] = "Robyn Harrison";
        task.getTaskNames()[0] = "Login Feature";
        task.getTaskDurations()[0] = 8;
        task.getTaskStatuses()[0] = "To Do";
        task.getTaskIDs()[0] = task.createTaskID(task.getTaskNames()[0], 1, task.getDevelopers()[0]);

        // Manually add second task
        task.getDevelopers()[1] = "Mike Smith";
        task.getTaskNames()[1] = "Add Task Feature";
        task.getTaskDurations()[1] = 10;
        task.getTaskStatuses()[1] = "Doing";
        task.getTaskIDs()[1] = task.createTaskID(task.getTaskNames()[1], 2, task.getDevelopers()[1]);

        // Set task count
        // Note: Since taskCount is private and there's no setter, 
        // you might need to adjust the Task class to allow setting taskCount for testing purposes.
        // Alternatively, you can simulate adding tasks using the addTasks method with mocked inputs.
        // For simplicity, we'll assume taskCount can be set here (not recommended for encapsulation).
        // If not possible, consider refactoring the Task class.
        // task.taskCount = 2; // Not accessible

        // Since taskCount is not accessible, we'll verify based on the expected size
        // Validate first task
        assertEquals("Login Feature", task.getTaskNames()[0], "First task name should be 'Login Feature'");
        assertEquals("Robyn Harrison", task.getDevelopers()[0], "First developer should be 'Robyn Harrison'");
        assertEquals(8, task.getTaskDurations()[0], "First task duration should be 8 hours");
        assertEquals("To Do", task.getTaskStatuses()[0], "First task status should be 'To Do'");
        assertEquals("LO:1:ROB", task.getTaskIDs()[0], "First task ID should be 'LO:1:ROB'");

        // Validate second task
        assertEquals("Add Task Feature", task.getTaskNames()[1], "Second task name should be 'Add Task Feature'");
        assertEquals("Mike Smith", task.getDevelopers()[1], "Second developer should be 'Mike Smith'");
        assertEquals(10, task.getTaskDurations()[1], "Second task duration should be 10 hours");
        assertEquals("Doing", task.getTaskStatuses()[1], "Second task status should be 'Doing'");
        assertEquals("AD:2:MIK", task.getTaskIDs()[1], "Second task ID should be 'AD:2:MIK'");
    }

    /**
     * Test the creation of task IDs with different inputs.
     */
    @Test
    public void testCreateTaskIDWithDifferentInputs() {
        Task task = new Task(1);

        // Test case 3
        String taskID3 = task.createTaskID("Bug Fix", 3, "Anna Lee");
        assertEquals("BU:3:ANN", taskID3, "Task ID should be BU:3:ANN");

        // Test case 4
        String taskID4 = task.createTaskID("Design Module", 4, "John Doe");
        assertEquals("DE:4:JOH", taskID4, "Task ID should be DE:4:JOH");
    }

    /**
     * Test of validateDeveloperDetails method, of class Task.
     */
    @Test
    public void testValidateDeveloperDetails() {
        System.out.println("validateDeveloperDetails");
        String developerDetails = "";
        Task instance = null;
        boolean expResult = false;
        boolean result = instance.validateDeveloperDetails(developerDetails);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        String taskDescription = "";
        Task instance = null;
        boolean expResult = false;
        boolean result = instance.checkTaskDescription(taskDescription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        int details = 0;
        Task instance = null;
        String expResult = "";
        String result = instance.printTaskDetails(details);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayDoneTasks method, of class Task.
     */
    @Test
    public void testDisplayDoneTasks() {
        System.out.println("displayDoneTasks");
        Task instance = null;
        instance.displayDoneTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestTask method, of class Task.
     */
    @Test
    public void testDisplayLongestTask() {
        System.out.println("displayLongestTask");
        Task instance = null;
        instance.displayLongestTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByTaskName method, of class Task.
     */
    @Test
    public void testSearchByTaskName() {
        System.out.println("searchByTaskName");
        String taskName = "";
        Task instance = null;
        instance.searchByTaskName(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class Task.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        String taskName = "";
        Task instance = null;
        instance.deleteTask(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayFullReport method, of class Task.
     */
    @Test
    public void testDisplayFullReport() {
        System.out.println("displayFullReport");
        Task instance = null;
        instance.displayFullReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Additional tests can be added here for other functionalities of the Task class.
     * However, methods that involve UI components like JOptionPane are not easily testable using standard unit tests.
     * Consider refactoring those methods to separate logic from UI to facilitate testing.
     */
}
