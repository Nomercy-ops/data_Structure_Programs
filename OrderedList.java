/**
 *
 * @author Rikesh Chhetri
 * @version 1.0
 * @Created_on: 17.06.21
 *
 * purpose: is to do Read and Write operations of numbers on a file using orderList
 * and Linked list.
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

public class OrderedList {

    private static LinkedList<Integer> orderedList = new LinkedList<>();

    /**
     * This is the method for reading the numbers from a file. It uses buffer
     * reader to read the whole line of a file and does remove any dot present
     * in file. It also convert lines to a string array.
     */
    
    public static void ReadNumberFromFile() {


        String[] strings;	//string array to store numbers in each line
        //	buffered reader to read from the file
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader("OrderedList.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line;	//store line from file
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\.", "");	//removes dots in the file
                strings = line.split(" ");	//	puts words into the string array

                //	converts strings to integers and adds to the list 
                for (String integer : strings) {
                    orderedList.add(Integer.parseInt(integer));
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
       
    }

    /**
     * This method is used for writing numbers into a file. It search for a number
     * if its not present then it adds user inputs number to a file. It also
     * removes the number if it is present in the files.
     */

    private static void WriteNumberToFile() {
         orderedList.list();
        int search;
        try ( //scanner to get the user input
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to search: ");
            search = scanner.nextInt(); //	number to be searched in the file
        }

        int pos; //index of the number in the list

        if ((pos = orderedList.index(search)) == -1) {	//number is not in the file
            System.out.println("This number is not in the file. Adding it to the list.");
            orderedList.add(search);
        } else {	//	number is in the file
            System.out.println("Number is at " + pos + ". Removing it from list.");
            orderedList.remove(search);
        }
        try {	//	writes the new list to the file
            int size = orderedList.size();	//	size of the list
            try ( //	print writer to write in the file
                    PrintWriter printWriter = new PrintWriter("OrderedList.txt")) {
                for (int i = 0; i < size; i++) {
                    int integer = orderedList.pop(0);
                    printWriter.write(integer + " ");
                }
            }
        } catch (FileNotFoundException e) {
       
        }
    }


/**
 * This is the main method for the UnOrdered List class. From her we can perform
 * Read and Write of words on a file.
 *
 * @param args
 */
    
public static void main(String[] args) {

        ReadNumberFromFile();
        WriteNumberToFile();
    }

}
