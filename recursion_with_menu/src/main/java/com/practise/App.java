package com.practise;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    // DECLARE VARIABLES
    static int base;
    static int limit;
    static int multiple = 0;
    static int result;
    static int num;

    public static void main(String[] args) {
        /*
         * CREATE A TABLE OF MULTIPLES OF AN INTEGER
         * REQUEST A USER TO ENTER A BASE NUMBER
         * REQUEST A USER TO ENTER I LIMIT
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Table of multiples.");
        System.out.println("2. Even or Odd.");
        System.out.printf("\n\nChoose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                // request user input for base and multiple
                System.out.printf("Enter base number: ");
                base = scanner.nextInt();
                System.out.printf("\nEnter table limit: ");
                limit = scanner.nextInt();
                // call the recursive method
                multipleRecursion();
                break;
            case 2:
                // check if a number is odd or even
                System.out.printf("Enter starting number: ");
                num = scanner.nextInt();
                System.out.printf("\nEnter the last number: ");
                limit = scanner.nextInt();
                oddOreven();
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

        scanner.close();

    }// end main function

    // recursive method
    public static int multipleRecursion() {

        /*
         * limit in if statements inside the recursiove method
         * user float/double, ==, error if 2.3, 2>3
         * newline char \n
         */
        if (multiple >= limit) {
            return 0; // break the method
        } else {
            result = base * multiple;
            // System.out.printf("\n %d * %d = %d", base, multiple, result);
            System.out.println(base + " * " + multiple + " = " + result);

            // increment the multiple
            multiple++;

            // kwi return statement you recall the function
            return multipleRecursion();
        }

    }// end recursive

    // odd of even function
    public static int oddOreven() {
        if (num <= limit) {
            // check uf it is even
            if (num % 2 == 0) {// then its even
                System.out.println(num + " is Even");
            } else { // else its odd
                System.out.println(num + " is odd");
            }

            // increment the starting number (num)
            num++;

            // then recall the function
            return oddOreven();
        } else {
            return 0;
        }
    }

}
