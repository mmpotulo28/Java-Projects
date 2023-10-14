package com.classes;

import java.util.Scanner;

//import your class

/**
 * Hello world!
 *
 */
public class App {

    // creare student records object
    static StudentRecords student = new StudentRecords();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // create option menu
        Boolean exit = false;
        while (exit == false) {
            // clear terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // menu
            System.out.println("1. use Get and Set methods to for student records:");
            System.out.println("2. Use Generics to set and get student records:");
            System.out.println("3. Search for a Student:");
            System.out.println("4. Exit:");

            System.out.println("\nWhat would you like to do?: ");
            int opt = scan.nextInt();

            switch (opt) {
                case 1: // set student records
                    setStdRecord();
                    break;

                case 2: // set student records using generics
                    setGen();
                    break;

                case 3: // method to search for a specific student
                    searchStudent();
                    break;

                case 4: // exit the program
                    exit = true;
                    break;

                default:
                    System.out.println("Wrong Option!\n");
                    break;
            } // end menu

            // ask user to exit or ..
            System.out.print("\nWould you like to exit (y/n): ");
            String exOpt = scan.next();

            if (exOpt.equals("y") || exOpt.equals("Y")) {
                exit = true;
                break;
            } else {
                exit = false;
            }
        }

    }

    private static void searchStudent() {
        Boolean loop = true;

        while (loop) {

            System.out.print("\n\nSearch for a student? (y/n): ");
            String choice = scan.next();

            if (choice.equals("y") || choice.equals("Y")) {
                System.out.print("Enter student number: ");
                int stdNo = scan.nextInt();

                // pass these varable values to the searchStudent method on StudentRecords class
                student.searchStudent(stdNo);
            } else {
                loop = false;
                System.out.println("\n\n");

            }
        }
    }

    private static void setGen() {
        Boolean loop = true;

        while (loop) {

            System.out.println("\n\nEnter student records: ");
            System.out.print("Enter student name: ");
            String name = scan.next();
            System.out.print("Enter student age: ");
            int age = scan.nextInt();
            System.out.print("Enter student course: ");
            String course = scan.next();
            System.out.print("Enter student number: ");
            int stdNo = scan.nextInt();

            // pass these varable values to the setGenerics method on StudentRecords class
            student.setGenerics(name, age, course, stdNo);
            System.out.println("Student records added successfully!");

            // ask user to add another record or cancel
            System.out.print("\nAdd another record? (y/n): ");
            String choice = scan.next();

            // if user enters y, loop will continue
            if (choice.equals("y") || choice.equals("Y")) {
                loop = true;
            } else {
                loop = false;
                System.out.println("\n\n");

            }

        }

        // after exiting loop print details
        System.out.println("Student Names: " + student.getNames());
        System.out.println("Student Ages: " + student.getAges());
        System.out.println("Student Courses: " + student.getCourses());
        System.out.println("Student Numbers: " + student.getStdNos());
    }

    private static void setStdRecord() {
        System.out.print("Student Name: ");
        student.setName(scan.next());
        System.out.print("Student Number: ");
        student.setStdNo(scan.nextInt());
        System.out.print("Age: ");
        student.setAge(scan.nextInt());
        System.out.print("Course Code: ");
        student.setCourse(scan.next());

        // print student records
        System.out.println("\n\nHere are the student Records you just entered");
        System.out.println("\nStudent Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Course: " + student.getCourse());
        System.out.println("Student Number: " + student.getStdNo());
    }

}
