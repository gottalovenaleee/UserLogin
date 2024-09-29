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
public class LogInClassTest {
    /**
     * Test of checkUserName method, of class LogInClass.
     */
    @org.junit.jupiter.api.Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        boolean expResult = false;
        boolean result = LogInClass.checkUserName(username);
         assertEquals(expResult, result);
        assertTrue(LogInClass.checkUserName("user_"));
        assertTrue(LogInClass.checkUserName("abc_d"));
        assertFalse(LogInClass.checkUserName("user")); // No underscore
        assertFalse(LogInClass.checkUserName("username_")); // Too long
       }

    /**
     * Test of checkPasswordComplexity method, of class LogInClass.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        boolean expResult = false;
        boolean result = LogInClass.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        assertTrue(LogInClass.checkPasswordComplexity("Passw0rd!"));
        assertTrue(LogInClass.checkPasswordComplexity("Complex1$Password"));
    }

    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexityInvalid() {
        assertFalse(LogInClass.checkPasswordComplexity("pass")); // Too short
        assertFalse(LogInClass.checkPasswordComplexity("password")); // No capital, digit, special
        assertFalse(LogInClass.checkPasswordComplexity("PASSWORD1")); // No special character
        assertFalse(LogInClass.checkPasswordComplexity("Pass!")); // Too short
    }

    /**
     * Test of registerUser method, of class LogInClass.
     */
    @org.junit.jupiter.api.Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String fname = "John";
        String lname = "Doe";
        String username = "user_";
        String password = "Passw0rd!";
        String expResult = "";
        String result = LogInClass.registerUser(fname, lname, username, password);
        assertEquals("User registered successfully.", result);
    }

    @org.junit.jupiter.api.Test
    public void testRegisterUserInvalidUserName() {
        String result = LogInClass.registerUser("John", "Doe", "user", "Passw0rd!");
        assertEquals("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    /**
     * Test of loginUser method, of class LogInClass.
     */
    @org.junit.jupiter.api.Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String storedUsername = "user_";
        String storedPassword = "Passw0rd!";
        String inputUsername = "user_";
        String inputPassword = "Passw0rd!";
        boolean expResult = true;
        boolean result = LogInClass.loginUser(storedUsername, storedPassword, inputUsername, inputPassword);
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    public void testLoginUserInvalidUsername() {
        assertFalse(LogInClass.loginUser("user_", "Passw0rd!", "wrongUser", "Passw0rd!"));
    }

    @org.junit.jupiter.api.Test
    public void testLoginUserInvalidPassword() {
        assertFalse(LogInClass.loginUser("user_", "Passw0rd!", "user_", "wrongPassword"));
    }

    /**
     * Test of returnLoginStatus method, of class LogInClass.
     */
    @org.junit.jupiter.api.Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String fname = "John";
        String lname = "Doe";
        String username = "user_";
        String password = "Passw0rd!";
        assertEquals("Login successful", LogInClass.returnLoginStatus(fname, lname, username, password));
    }
}
