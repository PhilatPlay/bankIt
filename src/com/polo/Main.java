package com.polo;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // User Dao
        UserDAO dao =  UserDAOFactory.getUserDao();
        TransactionDAO tdao =  TransactionDAOFactory.getTransactionDao();
        int userInput;
        int userInputC2 = 0;

        Scanner scanner = new Scanner(System.in);
        // Write data you want to insert
        ScreenView sv = new ScreenView();
        sv.printInitScreen();
        userInput = scanner.nextInt();

        switch (userInput) {
            case 2:
                // need actual log in logic.  *****************************************************
                System.out.println("Please enter an email address.");
                String email = scanner.next();
                System.out.println("Please enter your password.");
                String password = scanner.next();
                System.out.println("You've logged in!");

                break;
            case 1:
                System.out.println("Please enter your first name.");
                String firstName = scanner.next();
                System.out.println("Please enter your name.");
                String lastName = scanner.next();
                System.out.println("Please enter an email address.");
                String name = firstName + " " + lastName;
                email = scanner.next();
                System.out.println("Please enter your age.");
                int age = scanner.nextInt();
                System.out.println("Please create a Password");
                password = scanner.next();
                Boolean loggedIn = true;
                System.out.println("You've logged in!");

                //defining new user
                User user = new User();
                user.setId();
                user.setName(name);
                user.setEmail(email);
                user.setAge(age);
                user.setRole("user");
                user.setAccountBalance(0);
                user.setLoggedIn(true);
                    // adding/ creating new user
                    dao.addUser(user);
                break;
        }
        // after logging in we are here ********************
        double amount= scanner.nextDouble();
        String transactionLabel = "deposit";

        Transaction transaction = new Transaction();
        transaction.setTransaction_id();
        transaction.setUserId(13);
        transaction.setAmount(amount);
        transaction.setTransactionLabel(transactionLabel);
        transaction.setReceiver_id(0);

        // adding/ creating new transaction
        tdao.addTransaction(transaction);
        System.out.println("Your deposit of " + amount + " was successful.");
        sv.userOptions();
        userInputC2 = scanner.nextInt();

        switch (userInputC2) {
            case 1:

                System.out.println("What amount are you depositing?");
                amount= scanner.nextDouble();
                transactionLabel = "deposit";

                transaction = new Transaction();
                transaction.setTransaction_id();
                transaction.setUserId(13);
                transaction.setAmount(amount);
                transaction.setTransactionLabel(transactionLabel);
                transaction.setReceiver_id(0);

                // adding/ creating new transaction
                tdao.addTransaction(transaction);
                System.out.println("Your deposit of " + amount + " was successful.");

                break;
            case 2:

                System.out.println("What amount are you withdrawing?");
                amount= scanner.nextDouble();
                transactionLabel = "withdraw";

                transaction = new Transaction();
                transaction.setTransaction_id();
                transaction.setUserId(13);
                transaction.setAmount(amount);
                transaction.setTransactionLabel(transactionLabel);
                transaction.setReceiver_id(0);

                // adding/ creating new transaction
                tdao.addTransaction(transaction);
                System.out.println("Your withdraw of " + amount + " was successful.");

                break;
            case 3:

                System.out.println("What amount are you Transferring?");
                amount= scanner.nextDouble();
                System.out.println("Please enter the recipient's account number.");
                int id = scanner.nextInt();
                transactionLabel = "transfer";

                transaction = new Transaction();
                transaction.setTransaction_id();
                transaction.setUserId(13);
                transaction.setAmount(amount);
                transaction.setTransactionLabel(transactionLabel);
                transaction.setReceiver_id(0);

                // adding/ creating new transaction
                tdao.addTransaction(transaction);
                System.out.println("Your transfer of $" + amount + " was successful.");

                break;
            case 4:
                tdao.getUserTransactions(13);


                break;
        }

    }
}


//    So it should look like this:
//        id = id_input
//        printEmployee(dao.getEmployeeByID);
//        field1 = field1_input
//        field2 = ...
//        fieldn = fieldn_input
//        dao.updateUserABalance(amount, 13);


