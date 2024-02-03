// Kiarash Hesampour
// Comp 585 
// Project 1 - Basic Calculator - Part 1
// 02/02/2024

import java.util.*;
import java.io.*;

public class CalculatorApp {

    
    public static void main(String[] args) {
        PrintStream prt = System.out;


        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        prt.println("\nWelcome to the Basic Calculator\n==============================");

        while (true) {
            prt.println("-----------------------------------------------\nPlease Select one of the Available Operations Below:");
            prt.println("1. Add Operation");
            prt.println("2. Subtract Operation");
            prt.println("3. Multiply Operation");
            prt.println("4. Divide Operation");
            prt.println("5. Modulus Operation");
            prt.println("6. Power of 2 Operation (Enter only one number)");
            prt.println("7. Square Root Operation (Enter only one number)");
            prt.println("8. inverse Operation (1/x) (Enter only one number)");
            prt.println("9. Exit");
            prt.print("Please Enter your selection => : ");

            int choice = getIntInput(scanner);

            if (choice == 9) {
                prt.println("Exiting, Thank you for using Calculator. Goodbye :) ");
                break;
            }

            double num1 = 0, num2 = 0;
            if (choice >= 1 && choice <= 5) {
                num1 = getNumberInput(scanner, " Please Enter first number: ");
                num2 = getNumberInput(scanner, "Please Enter second number: ");
            } else if (choice >= 6 && choice <= 8) {
                num1 = getNumberInput(scanner, " Please Enter the number: ");
            }

            try {
                double result = performOperation(calculator, choice, num1, num2);
                prt.printf("-------------\nResult: %.2f\n------------", result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                prt.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static int getIntInput(Scanner scanner) {
        PrintStream prt = System.out;

        while (!scanner.hasNextInt()) {
            prt.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            prt.print("Select an operation (1-9): ");
        }
        return scanner.nextInt();
    }

    private static double getNumberInput(Scanner scanner, String message) {

        PrintStream prt = System.out;

        prt.print(message);
        while (!scanner.hasNextDouble()) {
            prt.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Consume the invalid input
            prt.print(message);
        }
        return scanner.nextDouble();
    }

    private static double performOperation(Calculator calculator, int choice, double num1, double num2) {
        switch (choice) {
            case 1: return calculator.add(num1, num2);
            case 2: return calculator.subtract(num1, num2);
            case 3: return calculator.multiply(num1, num2);
            case 4: return calculator.divide(num1, num2);
            case 5: return calculator.mod(num1, num2);
            case 6: return calculator.powerOfTwo(num1);
            case 7: return calculator.squareRoot(num1);
            case 8: return calculator.inverse(num1);
            default: throw new IllegalArgumentException("Invalid choice. Please select a valid operation.");
        }
    }

    static class Calculator {

        public double add(double num1, double num2) {
            return num1 + num2;
        }

        public double subtract(double num1, double num2) {
            return num1 - num2;
        }

        public double multiply(double num1, double num2) {
            return num1 * num2;
        }

        public double divide(double num1, double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("Sorry , Division by zero is not possible :( ");
            }
            return num1 / num2;
        }

        public double mod(double num1, double num2) {
            return num1 % num2;
        }

        public double powerOfTwo(double num) {
            return Math.pow(num, 2);
        }

        public double squareRoot(double num) {
            if (num < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number :( ");
            }
            return Math.sqrt(num);
        }

        public double inverse(double num) {
            if (num == 0) {
                throw new ArithmeticException(" Sorry, Cannot divide by zero :( ");
            }
            return 1 / num;
        }
    }
}
