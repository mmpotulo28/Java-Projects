package com.arrays;

public class App {

    // global varibales

    public static void main(String[] args) {

        // local varibales
        int[] array1 = { 3, 2, 5, 1, 4 };
        int searchElem = 6;

        // linear Searching
        // linearSearching(array1, searchElem); // pass parameters to the method
        System.out.println("\nOriginal Array:");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]);
        }

        System.out.println("\n");

        // selection sort
        System.out.println("Sorted Array:");
        selectionSort(array1);

        // uphinde ub
    }

    // recieve those passed parameters
    // when accepting parameters in Java you have to specify the data types you want
    // them to be

    public static void linearSearching(int[] arr, int elem) {

        int position = -1;
        // we want to search for "elem" on the "arr" array
        // loop throught the array and compare each element with elem
        for (int i = 0; i < arr.length; i++) {
            // if the current element on the array is equal to "elem"
            if (arr[i] == elem) {
                position = i; // print on the method instead of on the main method
                System.out.println(elem + " was found at position: " + i);
                break; // stop the loop
            }
        }

        // if we did not find the element
        if (position == -1) {
            System.out.println(elem + " was not found on the array!");
        }
    }

    /************* Selection Sorting algrotithm *****/
    public static void selectionSort(int[] arr) {
        int min = 0;

        // sort the recived arr in ascending order
        // loop throught the array
        for (int j = 0; j < arr.length * 2; j++) { // recheck the arrays multiple times

            //innerLoop is for swapping (sorting)
            for (int i = 0; i < arr.length - 1; i++) { // loop thorugh the array
                // compare the current element with the next, if its bigger, then swap
                //do this till the last element
                if (arr[i] > arr[i + 1]) {
                    min = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = min;
                }
            }

        }//outer loop

        //print the array
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d", arr[i]);
        }
 
    }

}
