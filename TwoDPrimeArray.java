/**
 *
 * @author Rikesh Chhetri
 * @version 1.0
 * @Created_on: 17.06.21
 *
 * purpose: is to find and store the prime number in 2D Array.
 *
 */

package com.bridgelabz.DataStructurePrograms;

import com.bridgelabz.DataStructurePrograms.Utility.Helper;

public class TwoDPrimeArray {

    /**
     * This is the main method method of the 2d prime array.
     * We have used 2d array for storing range in first dimension and in 
     * the 2nd doimension we have stored the prime numbers.
     * @param args 
     */
    
    public static void main(String[] args) {
        // arrays for storing prime
        int array[][] = new int[10][100];
        int prime[][] = new int[10][100];
        int temp = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                array[i][j] = temp;
                temp++;
            }
        }

        // calling for isPrime method from a utility file.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                if (Helper.isPrime(array[i][j])) {
                    prime[i][j] = array[i][j];
                } else {
                    prime[i][j] = -1;
                }
            }
        }

        // loop for storing and  printing the prime number
        for (int i[] : prime) {

            for (int j : i) {
                if (j != -1 && j != 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println("\n");
        }

    }

}
