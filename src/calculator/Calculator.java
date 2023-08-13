package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO 1. Application should not close after thrown exception.
//TODO 2.

public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private int result;
    private String exit = "no";
    private final Scanner scan = new Scanner(System.in);

    public void run() {

        do {
            logic();

        } while (exit.equals("yes"));
    }

    private void logic() {

        try {

            System.out.print("Enter first number: ");
            firstNumber = scan.nextInt();

            System.out.print("Enter second number: ");
            secondNumber = scan.nextInt();

        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());

        }

            System.out.print("Enter action: ");
        try {
            switch (scan.next().charAt(0)) {
                case '+' -> result = firstNumber + secondNumber;
                case '-' -> result = firstNumber - secondNumber;
                case '*' -> result = firstNumber * secondNumber;
                case '/' -> result = firstNumber / secondNumber;
                default -> {
                    System.err.println("You input invalid action");

                }
            }
            System.out.println("Result: " + result);
            System.out.print("Do you want continue? no / yes: ");
            exit = scan.next();

        } catch (ArithmeticException e) {
            System.err.println("Division by zero");

        }

    }

}
