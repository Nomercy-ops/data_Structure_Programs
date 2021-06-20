/**
 *
 * @author Rikesh Chhetri
 * @version 1.0
 * @Created_on: 17.06.21
 *
 * purpose: is to balanced the user input equations by using the stacks.
 *
 */


package com.bridgelabz.DataStructurePrograms;

import com.bridgelabz.DataStructurePrograms.Utility.MyStack;
import java.util.Scanner;

public class BalancedParenthesisUsingStack {
    
    /**
     * This is the main method of balanced parenthesis program.
     * It uses the my stack utility file for performing operations
     * here use input of equations are taken and by using push pop we wil balamnced the equations.
     * @param args 
     */

    public static void main(String[] args) {

        // stack object to store parentheses
        MyStack<Character> parenthesesSatck = new MyStack<>();
        String equation;
         // scanner to get user input
        try (
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter equation to check: ");
            equation = scanner.nextLine(); // equation
        }

        // equation in character array
        char[] equationCharcaterArray = equation.toCharArray();

        // pushes opening braces in stack and pops them out when closing braces occur
        for (char character : equationCharcaterArray) {
            if (character == '(') {
                parenthesesSatck.push(character);
            } else if (character == ')') {
                //	closing bracket before an opening bracket
                if (parenthesesSatck.isEmpty()) {
                    System.out.println("Equation is balanced.");
                    return;
                } else {
                    parenthesesSatck.pop();
                }
            }
        }

        if (parenthesesSatck.isEmpty()) {	//	balanced equation
            System.out.println("Equation is balanced.");
        } else {
            System.out.println("Enquation is not balanced.");
        }
    }
}
