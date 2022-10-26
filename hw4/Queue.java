package hw4;

public class Queue implements List {
    // Implement Queue using Linked List with tail
    Node head;
    Node tail;

    /*
     * This method use to add new element to queue
     * by insert new element at the end of queue
     */
    public void push(Node node) {
        node.next = null; // make sure this is end node
        if (head == null) { // if queue is empty declare it to be head
            head = node;
        } else { // if queue already populated then just add it to tail
            tail.next = node;
        }
        tail = node; // new node must be tail element due to queue property
    }

    /*
     * This function use to remove first element from the queue
     * and move the head to the next one
     */
    public void pop() {
        if (head != null) { // make sure list does not empty
            if (head != tail) { // if it was last element or not
                head = head.next; // if not change head to the next one
            } else { // otherwise declare this queue to be empty
                head = null;
                tail = null;
            }
        } else { // if empty report error
            System.out.println("Error: Queue Underflow");
        }
    }

    /*
     * This function use to get the first element of queue
     * it will return null if queue is empty otherwise it will return the first
     * element of queue
     */
    public Node top() {
        return head;
    }

}
