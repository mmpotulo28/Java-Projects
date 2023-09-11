package com.practise;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    static int start = 0;

    public static void main(String[] args) {

        // decalre local variables
        int option;
        int startingP;
        int num1;
        int base;
        boolean running = true;

        // Create scanner object to get the option
        Scanner scanner = new Scanner(System.in);

        while (running) {

            // clear terminal
            System.out.print("\033[H\033[2J");

            //reset varaible
            option = 0;
            running = true;

            // setup main menu
            System.out.println("********************************************");
            System.out.println("Welcome: what would you like to do?\n");
            System.out.println("\t1: Count Up to 10 using recursion.");
            System.out.println("\t2: Check which numbers are even or odd.");
            System.out.println("\t3: Calculate the power of a number.");
            System.out.println("\t4: Exit program.");

            System.out.printf("\nChoose 1 option: ");
            option = scanner.nextInt(); // get integer value from scanner
            System.out.println("*******************************************");

            switch (option) {
                case 1:// clear terminal
                    System.out.print("\033[H\033[2J");
                    System.out.printf("\nEnter staring point: ");
                    startingP = scanner.nextInt();

                    counterRecursion(startingP);
                    System.out.println("\n");
                    break;

                case 2:// clear terminal
                    System.out.print("\033[H\033[2J");
                    // get 1st number
                    System.out.printf("\nEnter staring number (up to 9): ");
                    num1 = scanner.nextInt();

                    // call checking function
                    oddOReven(num1);
                    System.out.println("\n");
                    break;

                case 3: /// power of a number
                    // clear terminal
                    System.out.print("\033[H\033[2J");

                    // get base
                    System.out.printf("\nEnter base: ");
                    base = scanner.nextInt();

                    // call function to calculate
                    mathPower(base, 1);
                    System.out.println("\n");
                    break;

                case 4:
                    // clear terminal
                    System.out.print("\033[H\033[2J");
                    running = false;
                    System.out.println("Goodbye\n");
                    break;

                default:// clear terminal
                    System.out.print("\033[H\033[2J");
                    System.out.println("Error: wrong option, enter a number between 1-3.");
                    break;
            }

            // ask if user would like to continue or exit
            if (running) {
                System.out.println("\nWould you like to continue? (y/n)");
                String answer = scanner.next();

                if (answer.equals("n")) {
                    running = false;
                    System.out.println("\nGoodbye\n");
                } else {
                    running = true;
                }
            }
        } // end while

        // close scanner
        scanner.close();

    }

    /********************* counter recursion function**** */
    public static int counterRecursion(int n) {
        if (n > 10) { // set a limit to avoid infinite loop
            return 0; // return 0 to stop the function
        } else {
            start = n;
            System.out.println(start); // print the value of n
        }

        // recall the function
        return counterRecursion(start + 1);
    }

    /********************* odd or even recursion function**** */
    public static int oddOReven(int num) {

        // set a recursion limit
        if (num > 10) {
            return 0;
        } else {
            start = num;

            // check if start is even or odd
            if (start % 2 == 0) {
                System.out.println(start + " is even");
            } else {
                System.out.println(start + " is odd");
            }

            return oddOReven(start + 1);
        }
    }

    /********************* math power recursion function**** */
    public static int mathPower(int base, int power) {
        if (power == 0 || power == 10) { // set recursion limit
            return 1;
        } else {
            start = (int) Math.pow(base, power); // Math.pow returns a double, cast to int
            System.out.println(base + "^" + power + " = " + start);

            return mathPower(base, power + 1); // recall function and increment power
        }
    }

}
