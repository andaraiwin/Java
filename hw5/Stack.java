package hw5;

public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    /*
     * This is constructor of Stack use for initialize Stack with fixed capacity
     */
    public Stack(int cap) {
        arr = new Node[cap];
        capacity = cap;
        size = 0;
    }

    /*
     * This method add new element to the back of Stack and output nothing when
     * success
     * otherwise it will print "Stack Overflow!!!"
     */
    public void push(Node node) {
        if (!isFull()) { // this will run when stack is not full then it will add new element to arr
            arr[size] = node; // because size and last element are related then we just use size as index
            size++; // and update Stack size by 1
        } else { // otherwise it will report error
            System.out.println("Stack Overflow!!!");
        }
    }

    /*
     * This method remove element from the back of Stack and output removed Node
     * when success otherwise it will print "Stack Underflow!!!" and output null
     */
    public Node pop() {
        Node out = null;
        if (!isEmpty()) { // this will run when stack is not empty then it will remove last element of arr
            size--; // we deduct Stack size by 1 first to declare that we working on last element of
                    // arr
            out = arr[size]; // and we use size to determine where last element was and set it to output for
                             // further return
            arr[size] = null; // and then we set last element of Stack to null
        } else { // otherwise it will report error
            System.out.println("Stack Underflow!!!");
        }
        return out; // return output
    }

    /*
     * This method return status of Stack that full or not
     * Return will be true if stack is full or false otherwise
     */
    public boolean isFull() {
        return size == capacity; // full mean we cannot exceed capacity anymore
    }

    /*
     * This method return status of Stack that empty or not
     * Return will be true if stack is empty or false otherwise
     */
    public boolean isEmpty() {
        return size == 0; // empty mean no element in Stack
    }

    /*
     * This method use to visualize structure of Stack
     */
    public void printStack() {
        if (!isEmpty()) { // we determined first, is stack empty or not if empty then we will just report
                          // back to use that "Stack is empty dude~"
            System.out.print("[Bottom] ");
            for (int i = 0; i < size; ++i) { // and then we iterate through arr from 0 till current size and print out
                                             // every element's data
                System.out.print(arr[i].data + " ");
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}
