/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import static com.mycompany.login.LogInClass.checkPasswordComplexity;
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
            password = scanner.nextLine();
            
            username = "nale_"; // example username
            if (isValidUsername(username)){
                System.out.println("Username succesfully captured");
         } else{
                System.out.print("Username is not correctly formatted,please ensure than your username contains an underscore and is no more than 5 characters in length");
        // If all conditions are met, the username is valid 
            }
            
             password = "Naledi@16";  // example password
        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains atleast 8 characters,a capital letter, a number and a special character");
        }
       
    }
}
