package com.bridgelabz.DataStructurePrograms.Utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains all the needed methods for algorithms . And this class is
 * mainly created for reusable purpose.
 */

public class Helper {

    // reusable static Object for Scanner class
    public static Scanner scanner = new Scanner(System.in);
    public static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param search - Words to search or string to search.
     * @param binaryStringArray - array in which string is to be searched
     * @return position of the string if found else returns -1
     */
    
    public static int binarySearch(String search, String[] binaryStringArray) {
        int first = 0, last = binaryStringArray.length - 1;
        int middle;

        while (first <= last) {
            middle = (first + last) / 2;
            if (binaryStringArray[middle].compareTo(search) < 0) {
                last = middle - 1;
            } else if (binaryStringArray[middle].compareTo(search) > 0) {
                first = middle + 1;
            }
            if (binaryStringArray[middle].compareTo(search) == 0) {
                return middle;
            }
        }
        return -1;
    }

    /**
     * @param binaryStringArray - string array to sort
     * @return sorted string array using insertion sort Ascending order.
     */
    
    public static String[] insertionSortAscending(String[] binaryStringArray) {

        for (int i = 1; i < binaryStringArray.length; i++) {
            String key = binaryStringArray[i];
            int j = i - 1;
            while ((j > -1) && (binaryStringArray[j].compareTo(key) > 0)) {
                binaryStringArray[j + 1] = binaryStringArray[j];
                j--;
            }
            binaryStringArray[j + 1] = key;
        }

        return binaryStringArray;
    }

    /**
     * @param binaryIntArray - input integer array to sort
     * @return sorted integer array in ascending order using bubble sort.
     */
    
    public static int[] bubbleSortAscending(int[] binaryIntArray) {

        int length = binaryIntArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < (length - 1 - i); j++) {
                if (binaryIntArray[j] > binaryIntArray[j + 1]) {
                    int temp = binaryIntArray[j];
                    binaryIntArray[j] = binaryIntArray[j + 1];
                    binaryIntArray[j + 1] = temp;
                }
            }
        }
        return binaryIntArray;
    }

    /**
     * @param stringList - String array to be sorted
     * @return sorted string array in ascending order
     */
    
    public static String[] mergeSort(String[] stringList) {
        // checking the length
        if (stringList.length == 1) {
            return stringList;
        }

        // dividing string list array and storing it to first and last array. 
        String first[] = new String[stringList.length / 2];
        String last[] = new String[stringList.length - (stringList.length / 2)];

        // traversing into first array.
        for (int i = 0; i < first.length; i++) {
            first[i] = stringList[i];
        }
        int j = 0;
        for (int i = first.length; i < stringList.length; i++) {
            last[j] = stringList[i];
            j++;
        }
        // recursive method
        first = mergeSort(first);
        last = mergeSort(last);

        String[] returnArray = new String[stringList.length];
        int firstPos = 0, lastPos = 0;
        for (int i = 0; i < returnArray.length; i++) {
            if (lastPos == last.length) {
                returnArray[i] = first[firstPos];
                firstPos++;
            } else if (firstPos == first.length) {
                returnArray[i] = last[lastPos];
                lastPos++;
            } else if (first[firstPos].compareTo(last[lastPos]) > 0) {
                returnArray[i] = last[lastPos];
                lastPos++;
            } else {
                returnArray[i] = first[firstPos];
                firstPos++;
            }
        }
        return returnArray;
    }

    /**
     * @param range- up to which prime numbers are to be found
     * @return string array of prime numbers in a given range
     */
    
    public static String[] primeNumber(int range) {
        String[] array = new String[1000];
        int position = 0;
        for (int i = 2; i <= range; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if ((i % j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                array[position] = String.valueOf(i);
                position++;
            }
        }
        String[] returnArray = new String[position];
        for (int k = 0; k < position; k++) {
            returnArray[k] = array[k];
        }
        return returnArray;
    }
    
    /**
	 * function to chekc if given no is prime or not
	 * 
	 * @param n thenumber which to check for prime
	 * @return true if prime false if not
	 */
	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i== 0) {
				return false;
			}
		}
		return true;
	}

    /**
     * Returns true if strings are anagram else returns false
     *
     * @param string1
     * @param string2
     * @return true or false if it is a anagram
     *
     */
    
    public static boolean findAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] array1 = string1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = string2.toCharArray();
        Arrays.sort(array2);

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param string- string to check for palindrome
     * @return true if the string is palindrome else returns false
     */
    
    public static boolean palindrome(String string) {
        if (string.length() < 2) {
            return false;
        }
        char[] array = string.toCharArray();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] != array[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
