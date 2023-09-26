package com.arrays2;

import java.util.Random;
import java.util.Arrays;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int[] randomArray = new int[10];
        Random random = new Random();

        // randomly generate the array
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(0, 10);
        }

        // print original array
        printArray(randomArray);

        // sort the array 1st
        randomArray = sortArray(randomArray);

        // print sorted array
        printArray(randomArray);

        // remove duplicates on array
        randomArray = removeDuplicates(randomArray);

        // print the new array
        printArray(randomArray);

    }


    public static void printArray(int[] array) {
        System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static int[] sortArray(int[] array) {
        int temp = 0;

        // sort the array
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    // swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static int[] removeDuplicates(int[] array) {
        int[] newArray = new int[array.length];

        // remove duplicates
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i];
            int next = array[i + 1];

            if (current != next) {
                newArray[i] = current;
            }
        }

        // add the last element to the new array
        newArray[newArray.length - 1] = array[array.length - 1];

        return newArray;
    }
}
