package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO 1. Application should not close after thrown exception.
//TODO 2. Method maine should not be in class calculator.
// In class calculator should be method run.
// Method run should contain only while loop with invoking another private methods
public class Calculator {

    private static int firstNumber;
    private static int secondNumber;
    private static int result;
    private static String exit = "no";
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter first number: ");
                firstNumber = scan.nextInt();

                System.out.print("Enter second number: ");
                secondNumber = scan.nextInt();

            } catch (InputMismatchException e) {
                System.err.println("You input invalid number");
                return;
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
                        return;
                    }
                }
                System.out.println("Result: " + result);
                System.out.print("Do you want continue? no / yes: ");
                exit = scan.next();
            } catch (ArithmeticException e) {
                System.err.println("Division by zero");
            }
        } while (exit.equals("yes"));
    }

}
