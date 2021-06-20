package com.bridgelabz.DataStructurePrograms.Utility;

/**
 * This is the stack helper class for performing balanced parenthesis problems.
 * @author Rikesh chhetri
 * @param <T> 
 */
public class MyStack<T> {

    LinkedList<T> myLinkedList;

    public MyStack() {
        myLinkedList = new LinkedList<>();
    }

    public void push(T data) {
        myLinkedList.add(data);
    }

    public T pop() {
        return myLinkedList.pop();
    }

    public T peek() {
        T temp = myLinkedList.pop();
        myLinkedList.add(temp);
        return temp;
    }

    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    public int size() {
        return myLinkedList.size();
    }
}
