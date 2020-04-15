package org.example;

import org.example.controller.operators.WithdrawOperator;
import org.example.model.persistence.DataInMemory;

import java.util.Scanner;


/**
 * 1. New Deposit Operator - IAccountOperator
 * 2. Validate balance before Withdraw operation in (View? Controller? Operator?)
 * 3. Add Provider to get My Balance - IInfoProvider
 * 4. Add Provider to get My Transactions - IInfoProvider
 */

public class Application {
    private final DataInMemory dataInMemory = DataInMemory.getInstance();
    public static void main(String[] args) {
        Application app = new Application();
        app.run("Jerry", "BO10006789");
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private void run(String name, String account) {
        BankAccount bankAccount = new BankAccount(name, account);


        // Welcome to the BankApp
        print("Welcome " + name);
        print("Your current account is " + account);

        showMainMenu();
        selectOption(bankAccount);
    }

    private void showMainMenu() {
        // Main Menu
        print(System.lineSeparator());
        print("********************");
        print("(W) Withdraw");
        print("(D) Deposit");
        print("(B) My Balance");
        print("(T) My Transactions");
        print("(E) Exit");
        print("********************");
    }

    private void selectOption(BankAccount bankAccount) {
        // Press a key to select an option
        try (Scanner scanner = new Scanner(System.in)){
            boolean closeApp = false;
            char option;
            while (true) {
                System.out.print("Select an option: ");
                option = getSelectedOption(scanner);
                switch (option) {
                    case 'A':
                        showMainMenu();
                        break;
                    case 'E':
                        print("Exit...");
                        closeApp = true;
                        break;
                    case 'B':
                        print("My Balance is " + bankAccount.getBalance());
                        break;
                    case 'W':
                        withdraw(bankAccount);
                        break;
                    case 'D':

                        break;
                    default:
                        print(option + " is an invalid option");
                        break;
                }

                // Is running
                if (closeApp) {
                    break;
                }

                print("(A) Show All options");
            }
        }
    }

    private char getSelectedOption(Scanner scanner) {
        return scanner.nextLine().trim().toUpperCase().charAt(0);
    }

    private void withdraw(BankAccount bankAccount) {
        /*
        User should be able to select the amount
         */
        bankAccount.withdraw();
    }
}
