package com.practise;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // clear console
        System.out.print("\033[H\033[2J");

        /*** Declare variable ***/
        String[] article = { "the", "a", "one", "some", "any" };
        String[] noun = { "boy", "girl", "dog", "town", "car" };
        String[] verb = { "drove", "jumped", "ran", "walked", "skipped" };
        String[] prep = { "to", "from", "over", "under", "on" };
        // create a string to hold the sentence
        String sentence = new String();
        StringBuilder multipleSentence = new StringBuilder();

        // create random number generator
        Random random = new Random();

        for (int i = 0; i < 5; i++) {// for 5 sentences
            // create random array index for each array (on each array generate a new index)
            int articleIndex = random.nextInt(article.length);
            int nounIndex = random.nextInt(noun.length);
            int verbIndex = random.nextInt(verb.length);
            int prepIndex = random.nextInt(prep.length);
            int articleIndex2 = random.nextInt(article.length);
            int nounIndex2 = random.nextInt(noun.length);

            // contatenate each word form the arrray to form a sentence string
            sentence = article[articleIndex] + " " + noun[nounIndex] + " " + verb[verbIndex] + " " + prep[prepIndex]
                    + " " + article[articleIndex2] + " " + noun[nounIndex2] + ".";

            // Make the first letter of the sentence uppercase (generate a new sentence)
            sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);

            // add each sentence to a multipleSentence string builder (for file writting)
            multipleSentence.append(sentence + "\n");
        }

        // write to file (1st convert back to string, function accepts string)
        fileOperationWrite(multipleSentence.toString());
        System.out.println("\n"); // just to create space between the two outputs

        // read from file
        fileOperationRead();
        System.out.println("\n");
    }

    /************************* File Operations *******************/

    public static void fileOperationRead() {
        // read from file (read the sentence we wrote to the file)
        try {
            // create a file reader object
            FileReader fr = new FileReader("src/main/java/com/practise/sentence.txt");
            // read the file
            int i;
            // (read() returns -1 when there is no more data)
            while ((i = fr.read()) != -1) { // while there is still data to read from the file
                // fr.read() returns the character as a number so convert that back to character
                char c = (char) i;

                // print character by character
                System.out.print(c);
            }
            // close the file
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public static void fileOperationWrite(String sentence) {

        // create a file object
        File myFile = new File("src/main/java/com/practise/sentence.txt");

        // check if file exists
        if (myFile.exists()) {
            System.out.println("File already exists");
        } else {
            try { // saround with try catch block to catch any errors when creating the file
                  // create a new file
                myFile.createNewFile();
                System.out.println("File created successfully" + "\n\n");
            } catch (Exception e) {
                System.out.println("Error creating file" + "\n");
            }
        }

        // write to file
        try {
            // create a file writer object
            FileWriter fw = new FileWriter("src/main/java/com/practise/sentence.txt");
            // write sentence to file but dont overwrite its content
            fw.write(sentence);

            // close the file
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
