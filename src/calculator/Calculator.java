package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO 1. Application should not close after thrown exception.
//TODO 2.


public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private int result;
    private String exit = "y";
    private final Scanner scan = new Scanner(System.in);


    public void run() {
        System.out.println("-----------------------------");
        System.out.println("Console calculator");
        System.out.println("Action symbol is: * / + - ");
        System.out.println("-----------------------------");

        do {
            number();
            action();
        } while (exit.equals("y"));
    }

    private void number() {

        try {
            System.out.print("Enter first number: ");

            if (scan.hasNextInt()) {
                firstNumber = scan.nextInt();
                System.out.print("Enter second number: ");
                secondNumber = scan.nextInt();
            } else {
                System.out.println("It's not a number");
//                System.out.print("Enter first number: ");
            }
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }


    private void action() {
        try {
            System.out.print("Enter action: ");
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
        } catch (ArithmeticException e) {
            System.err.print("Division by zero");
        }
        System.out.print("Do you want continue? No, press any key / Yes, press Y : ");
        exit = scan.next();
    }
}


