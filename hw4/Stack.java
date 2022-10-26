package hw4;

public class Stack implements List {
    Node head;

    /*
     * This function use to add new element to stack
     * by insert new element at the front of stack
     */
    public void push(Node node) {
        if (head != null) { // when stack is not empty we must move head
            node.next = head;
        } else { // but when it empty the the first element will be the last element when push
                 // back occur again, then we must to terminated the end of stack
            node.next = null;
        }
        head = node;
    }

    /*
     * This function use to remove first element from the stack
     * and move the head to the next one
     */
    public void pop() {
        if (head != null) { // when if stack empty or not
            head = head.next; // if not empty the move the head
        } else { // but when it empty, it shall not continue and report back the error
            System.out.println("Error: Stack Underflow");
        }
    }

    /*
     * This function use to get the first element of stack
     * it will return null if stack is empty otherwise it will return the first
     * element of stack
     */
    public Node top() {
        return head;
    }

}
