package com.classes;

//imporrts
import java.util.LinkedList;
import java.util.Scanner;

public class Generics {
    // create linked list of student records
    private LinkedList<String> names = new LinkedList<String>();
    private LinkedList<Integer> ages = new LinkedList<Integer>();
    private LinkedList<String> course = new LinkedList<String>();
    private LinkedList<Integer> stdNo = new LinkedList<Integer>();

    private Scanner scan = new Scanner(System.in);

    // function with a menu of options
    public void menu() {
        // create option menu
        Boolean exit = false;
        while (exit == false) {
            // clear terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // menu
            System.out.println("1. Add Student Records:");
            System.out.println("2. Search for a Student:");
            System.out.println("3. Remove a Student:");
            System.out.println("4. Update a Student:");
            System.out.println("5. Print All records:");
            System.out.println("6. Exit:");

            System.out.println("\nWhat would you like to do?: ");
            int opt = scan.nextInt();

            switch (opt) {
                case 1: // set student records
                    addRecordLinked();
                    break;

                case 2: // method to search for a specific student
                    searchRecordLinked();
                    break;

                case 3: // method to remove a specific student
                    removeRecordLinked();
                    break;

                case 4: // method to update a specific student
                    updateRecordLinked();
                    break;

                case 5: // print all records
                    printAllLinked();
                    break;

                case 6: // exit the program
                    exit = true;
                    break;

                default:
                    System.out.println("Wrong Option!\n");
                    break;
            } // end menu

            // ask user to exit or ..
            System.out.print("\nWould you like to exit LinkedList (y/n): ");
            String exOpt = scan.next();

            if (exOpt.equals("y") || exOpt.equals("Y")) {
                exit = true;
                break; // break loop and exit the class method
            }
        }
    }

    private void printAllLinked() {
        // loop through all student numbers
        for (int i = 0; i < stdNo.size(); i++) {
            // print out records
            System.out.println("**************************************");
            System.out.println("Student Names: " + names.get(i));
            System.out.println("Student Ages: " + ages.get(i));
            System.out.println("Student Courses: " + course.get(i));
            System.out.println("Student Numbers: " + stdNo.get(i));
            System.out.println("**************************************\n");
        }
    }

    // function to set records
    private void addRecordLinked() {
        System.out.print("Enter Student Name: ");
        String name = scan.next();
        names.add(name);

        System.out.print("Enter Student Age: ");
        int age = scan.nextInt();
        ages.add(age);

        System.out.print("Enter Student Course: ");
        String crs = scan.next();
        course.add(crs);

        System.out.print("Enter Student Number: ");
        int std = scan.nextInt();
        stdNo.add(std);

        System.out.println("Student records added successfully!");

        // print out all records
        System.out.println("\n\nStudent Records: ");
        System.out.println("Student Names: " + names);
        System.out.println("Student Ages: " + ages);
        System.out.println("Student Courses: " + course);
        System.out.println("Student Numbers: " + stdNo);
    }

    // function to search for a record
    private void searchRecordLinked() {
        System.out.print("Enter Student Number: ");
        int num = scan.nextInt();

        // check if num exists
        if (stdNo.contains(num)) {
            // get all records of the student
            int index = stdNo.indexOf(num);

            // print out records
            System.out.println("\n\nStudent Records for: " + stdNo.get(index));
            System.out.println("Student Names: " + names.get(index));
            System.out.println("Student Ages: " + ages.get(index));
            System.out.println("Student Courses: " + course.get(index));
            System.out.println("Student Numbers: " + stdNo.get(index));

        } else {
            System.out.println("Student Number: " + num + " does not exist!");
        }
    }

    // function to remove a record using student number
    private void removeRecordLinked() {
        System.out.print("Enter Student Number: ");
        int num = scan.nextInt();

        // check if num exists
        if (stdNo.contains(num)) {
            // get all records of the student
            int index = stdNo.indexOf(num);

            // print out records
            System.out.println("\n\nStudent Records for: " + stdNo.get(index));
            System.out.println("Student Names: " + names.get(index));
            System.out.println("Student Ages: " + ages.get(index));
            System.out.println("Student Courses: " + course.get(index));
            System.out.println("Student Numbers: " + stdNo.get(index));

            // ask user if they want to delete the record
            System.out.print("\n\nDelete this record? (y/n): ");
            String choice = scan.next();

            // if user enters y, delete record
            if (choice.equals("y") || choice.equals("Y")) {
                names.remove(index);
                ages.remove(index);
                course.remove(index);
                stdNo.remove(index);

                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Record not deleted!");
            }

        } else {
            System.out.println("Student Number: " + num + " does not exist!");
        }
    }

    // function to update a record
    private void updateRecordLinked() {
        System.out.print("Enter Student Number: ");
        int num = scan.nextInt();

        // check if num exists
        if (stdNo.contains(num)) {
            // get all records of the student
            int index = stdNo.indexOf(num);

            // print out records
            System.out.println("\n\nStudent Records for: " + stdNo.get(index));
            System.out.println("Student Names: " + names.get(index));
            System.out.println("Student Ages: " + ages.get(index));
            System.out.println("Student Courses: " + course.get(index));
            System.out.println("Student Numbers: " + stdNo.get(index));

            // ask user if they want to update the record
            System.out.print("\n\nUpdate this record? (y/n): ");
            String choice = scan.next();

            // if user enters y, update record
            if (choice.equals("y") || choice.equals("Y")) {
                System.out.print("Enter Student Name: ");
                String name = scan.next();
                names.set(index, name); // provide the index of the element you want ot update

                System.out.print("Enter Student Age: ");
                int age = scan.nextInt();
                ages.set(index, age);

                System.out.print("Enter Student Course: ");
                String crs = scan.next();
                course.set(index, crs);

                System.out.print("Enter Student Number: ");
                int std = scan.nextInt();
                stdNo.set(index, std);

                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Record not updated!");
            }

        } else {
            System.out.println("Student Number: " + num + " does not exist!");
        }
    }
}
