package com.polo;

import java.util.ArrayList;
import java.util.Scanner;

public class ScreenView extends Object {
    Scanner scanner = new Scanner(System.in);


    public void printInitScreen() {
        String initScreen = "1. Enroll ---------> 2. Login";
        System.out.println(initScreen);
    }

//    public void printLoginScreen(email, password) {
//
//        System.out.println("Please enter an email address.");
//        String email = scanner.next();
//        System.out.println("Please enter your password.");
//        String password = scanner.next();
//
//    }

    public void printSupervisorScreen() {
        System.out.println("---------->");
        System.out.println("Select from the options below.");
        System.out.println("1. View User Accounts");
        System.out.println("2. View New Applicants");
        System.out.println("3. Cancel Account");
    }

    public void userOptions() {
        System.out.println("---------->");
        System.out.println("Hello, Select from the options below.");
        System.out.println("---------->");
        System.out.println("1. Make a Deposit ---> 2. Make a Make a Withdraw ---> 3. Transfer funds ---> 4. View recent Transactions");
    }
}




