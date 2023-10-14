package com.arrays2;

import java.util.Random;

/**
 * Hello world!
 * will join you in a sec
 */
public final class App {
    private App() {
    }

    /**
     * merge sort is to complicated honestly i doupt youll be asked to do it
     * its the hardest to understand of all the sorting algorithms
     * binary search is the most important you should familiarize yourself with it
     * insertion sort is the easiest to understand i works almost like selection
     * sort, which is the most common sorting algorithm
     * romoving duplicates on a n array is also important, but we cant change the
     * lenght of the array so we have to create a new array and copy the elements to
     * it, the removed elements will leave empty spaces which will automatically
     * fill with zeros
     * thats all for now!
     * i'll send you some visualizations of the algorithms if i can find them
     * perhaps next weeek we will do list/linkedList, maps, sets, and queues
     * (maybe).
     * i also want to give you an intro on classes and how to use classes to work
     * with data
     * on different files.
     * what are we doing today?
     * @param args The arguments of the program.
     */

    public static void main(String[] args) {

        // clear terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int[] randomArray = new int[10];
        Random random = new Random();

        // randomly generate the array
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(0, 10);
        }

        // print original array
        System.out.println("Original Array");
        printArray(randomArray);

        // sort the array 1st
        randomArray = sortArray(randomArray);

        // print sorted array
        System.out.println("\nSorted Array");
        printArray(randomArray);

        // search for the element (binary search) fucntion
        int element = 5;
        int index = binarySearch(randomArray, element);
        // print the index of the element
        System.out.println("\nIndex of " + element + " is " + index);

        // linear search
        int index2 = linearSearch(randomArray, 6);
        System.out.println("\nIndex of " + 6 + " is " + index2);

        // slecttion sort
        randomArray = selectionSort(randomArray);
        System.out.println("\nSelection Sort");
        printArray(randomArray);

        // remove duplicates
        int[] array2 = removeDuplicates(randomArray);
        System.out.println("\nRemove Duplicates");
        printArray(array2);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("\n");
    }

    public static int[] sortArray(int[] array) {
        int temp = 0;

        // sort the array insertion sort
        for (int i = 0; i < array.length; i++) { // this outer loop will run forward and starts at 0
            for (int j = i; j > 0; j--) { // this inner loop will run backwards and starts at current pos
                if (array[j] < array[j - 1]) { // if the element at current pos is less than the in previous pos
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        return array;
    }

    public static int binarySearch(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;

        // loop through the array
        while (start <= end) {
            int midpoint = (start + end) / 2;

            // if the element is at the midpoint
            if (array[midpoint] == element) {
                return midpoint; // if you got the eelement return the index
            } else if (array[midpoint] < element) { // if the element is greater than the element at midpoint
                start = midpoint + 1;
            } else { // if the element is less than the element at midpoint
                end = midpoint - 1;
            }
        }

        return -1; // if you did not find the element return -1

    }

    public static int linearSearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i; // if you got the eelement return the index
            }
        }

        return -1; // if you did not find the element return -1
    }

    public static int[] selectionSort(int[] array) {
        int temp = 0;

        // sort the array selectionSort
        for (int i = 0; i < array.length; i++) { // this outer loop iterate multiple times
            for (int j = 0; j < array.length - 1; j++) { // this checks the current element with the next
                if (array[j] < array[j + 1]) {
                    temp = array[j]; // swap the elements
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    public static int[] removeDuplicates(int[] array) {
        int[] temp = new int[array.length]; // create new array
        int j = 0;

        // this method requuires an array to be sorted
        for (int i = 0; i < array.length - 1; i++) { // loop throigh the array
            if (array[i] != array[i + 1]) {
                temp[j++] = array[i]; // if its not duplicate add it to the new array
            }
        }

        temp[j++] = array[array.length - 1]; // add the last element since we did not check it

        return temp;
    }

}