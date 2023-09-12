package com.practise;

//when doing file operations (java.io)
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//the reset
import java.util.Random;

public final class App { //if the name of your file

    /*
     * crerating a program to randomly generate sentences
     * the has to write those sentences on a file
     * 
     */

    // global variable declaration
    static String sentence;

    // static mean that the variable can be accessed anywhere without having to
    // create an object for it

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // clear terminal
        System.out.print("\033[H\033[2J");

        // declare arrays
        String[] noun = { "boy", "girl", "dog", "town", "car" };
        String[] article = { "the", "one", "a", "some", "any" };
        String[] verb = { "drove", "jumped", "ran", "walked", "skipped" };
        String[] prep = { "to", "from", "over", "under", "on" };

        /*
         * randomly pick words on each array
         * randomly generate i index on each array
         * we will use the index to pick a certain work on each array
         */

        // declare random number generator object
        Random random = new Random();
        StringBuilder multisentences = new StringBuilder();

        // use le object to randomly generate i indices.
        // index is the position of an element on an array (0-array.length).
        // we need an index that within bound ze array 0-4.
        // syntax of the sentences is like, article, noun, verb, prep, article, noun.

        for (int i = 0; i < 6; i++) {

            int articleIndex = random.nextInt(0, article.length);
            int nounIndex = random.nextInt(0, noun.length);
            int verbIndex = random.nextInt(0, verb.length);
            int prepIndex = random.nextInt(0, prep.length);
            int articleIndex2 = random.nextInt(0, article.length);
            int nounIndex2 = random.nextInt(0, article.length);

            // use the indices to get the word(elements) form the arrays\
            // concate
            sentence = article[articleIndex] + " " + noun[nounIndex] + " " + verb[verbIndex] + " "
                    + prep[prepIndex]
                    + " " + article[articleIndex2] + " " + noun[nounIndex2] + " ";

            // change the 1st letter of the sentence to upperCase
            sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);

            // add each sentence into the multiple sentence string builder
            // appending is like adding/pushing something at the end
            multisentences.append(sentence + "\n");
        } // end loop

        // extras
        System.out.println(sentence.charAt(5)); // this wil print the character at 5
        System.out.println(sentence.indexOf("e")); // this wil print the position of a certain charecter
        System.out.println(sentence.length()); // this wil print the length of the string

        // System.out.println(multisentences);

        System.out.println("\n\n");

        // 2nd part: writting the sentence to a file
        File myFile = new File("sentences.txt");

        // check if file exits, if not, create a new one.
        if (myFile.exists()) {
            System.out.println("file already exists.");
        } else {
            try { // try creating new file, if it doesnt work catch the error
                myFile.createNewFile(); // unhandled IO exception
                System.out.println("New file created!");
            } catch (IOException e) {
                System.out.println("Error, couldnt create new file!");
            }
        }

        // we can get 2 errrors, access denied/filenotfound

        try { // try writting to this file
            FileWriter fw = new FileWriter(myFile);
            // write the sentence to the file
            fw.write(multisentences.toString());
            // The method write(int) in the type OutputStreamWriter is not applicable for
            // the arguments (StringBuilder)
            fw.close(); // closing line

        } catch (SecurityException exception) {
            System.out.println("Error! access denied!");
        } catch (FileNotFoundException e) {
            System.out.println("Error! file not found");
        } catch (IOException e) {
            System.out.println("Couldn't write to file");
        }

        System.out.println("\n\n");
    }

}
