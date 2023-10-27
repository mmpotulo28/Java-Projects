package com.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
     * 
     * @param args The arguments of the program.
     */

    public static void main(String[] args) {
        // clear terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Random rand = new Random();

        // generate a double array with random numbers
        Double[] arr = new Double[10];
        for (int i = 0; i < arr.length; i++) {
            Double doubleNumber = rand.nextDouble(1.0, 50.0);
            arr[i] = Math.round(doubleNumber * 10.0) / 10.0;
        }

        // generate an int array with random numbers
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rand.nextInt(1, 15);
        }

        // print the arrays
        System.out.println("Double Arrray");
        printArray(arr);
        System.out.println("Int Arrray");
        printIntArr(arr2);

        // remove dublicates
        /*
         * 1. Genenerics
         * 2. Arrays
         */

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        // print set
        System.out.println(set);

        // differences between ArrayList, LinkedList, and Hashset/HashMap
        // add items kwi ArrayList and LinkedList

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        LinkedList<Integer> linkList = new LinkedList<Integer>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashMap<String, Double> hashMap = new HashMap<String, Double>();

        for (int i = 0; i < 10; i++) {
            arrList.add(i); // add to the end of the list
            linkList.add(i); // add to the end of the list
            hashSet.add(i); // add to the end of the list
        }

        genericPrint(arrList);

        // // remove items from the list
        // arrList.remove(0); // remove the first item
        // arrList.remove(arrList.size() - 1); // remove the last item

        // linkList.remove(0); // remove the first item
        // linkList.remove(linkList.size() - 1); // remove the last item

        // hashSet.remove(0); // remove the first item
        // hashSet.remove(hashSet.size() - 1); // remove the last item

        // we want hashMap of fruits and their prices
        // we want to be able to get the price of a fruit by its name
        hashMap.put("apple", 2.99);
        hashMap.put("banana", 1.99);
        hashMap.put("orange", 3.99);

        // retrieve the price of a fruit
        // System.out.println("Apple price: " + hashMap.get("apple"));,,
    }

    public static void printArray(Double[] arr) {
        for (Double d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static void printIntArr(int[] arr) {
        for (int d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    // create a generic method that prints an array of any type
    public static <T> void genericPrint(List<T> arr) {
        for (T d : arr) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    // get your ass back here!
    // unganya mntam
    // HAY SEE YOU TOMORROW!

}                                                                 