/**
 *
 * @author Rikesh Chhetri
 * @version 1.0
 * @Created_on: 17.06.21
 *
 * purpose: is is to do Read and Write operations of a words on a file using unorderList and Linked list.
 *
 */

package com.bridgelabz.DataStructurePrograms;

import com.bridgelabz.DataStructurePrograms.Utility.LinkedList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UnOrderedList {

    private static LinkedList<String> unOrderedLinkedList = new LinkedList<>();

    /**
     *  This is the method for reading the words from a file.
     *  It uses buffer reader to read the whole line of a file and does remove any dot present in file.
     *  It also convert lines to a string array.
     */
    public static void ReadWordsFromFile() {
        
        //strings array
        String[] strings; 
        BufferedReader bufferedReader = null; // buffered reader to read from file
        try {
            FileReader fileReader = new FileReader("UnorderedList.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\.", ""); // removes all the dots from the file
                strings = line.split(" "); // converts line to string array
                for (String string : strings) { // adds array elements to the list
                    unOrderedLinkedList.add(string);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
        unOrderedLinkedList.list(); // prints list elements
    }
    
    /**
     * This method is used for writing words into a file.
     * It search for a word if its not present then it adds user inputs words to a file.
     * It also removes the words if it is present in the files.
     */
    
    private static void WriteWordsToFile(){
      
        String wordSearch;
        try (Scanner scanner = new Scanner(System.in) // scanner to get user input
                ) {
            System.out.print("Enter a word to search: ");
            wordSearch = scanner.next(); // word to be searched
        }
        int position; // position of the word in the file

        if ((position = unOrderedLinkedList.index(wordSearch)) == -1) { // words are not present in the file
            System.out.println("This word is not in the file. Adding it to the list.");
            unOrderedLinkedList.add(wordSearch);
        } else { //	word found
            System.out.println("Word is at " + position + ". Removing it from list.");
            unOrderedLinkedList.remove(wordSearch);
        }
            //writes list to the file
        try { 
            int size = unOrderedLinkedList.size();
            try (PrintWriter printWriter = new PrintWriter("UnorderedList.txt")) {
                for (int i = 0; i < size; i++) {
                    String string = unOrderedLinkedList.pop(0);
                    printWriter.write(string + " ");
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    /**
     * This is the main method for the UnOrdered List class.
     * From her we can perform Read and Write of words on a file.
     * @param args 
     */
    
    public static void main(String[] args) {

     ReadWordsFromFile();
     WriteWordsToFile();
    }

}
