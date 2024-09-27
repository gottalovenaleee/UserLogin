/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Login {

    public static void main(String[] args) {
        //Declarations
    String fname, lname, username, password;
    // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
   // Prompt user to enter first name, last name, username, and password
        
        System.out.print("Enter first name: ");
            fname = scanner.nextLine();
        System.out.print("Enter last name: ");
            lname = scanner.nextLine();
        System.out.print("Enter username: ");
             username = scanner.nextLine();
        System.out.print("Enter password: ");
        String  
        // Create a new user account
        UserAccount account = new UserAccount(fname, lname, username, password);

        // Prompt user to enter login credentials
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        // Check if login credentials are valid
       public boolean isValidLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    }
}
