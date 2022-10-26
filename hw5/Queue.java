package hw5;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;

    /*
     * This is constructor of Queue use for initialize Queue with fixed capacity
     */
    public Queue(int cap) {
        capacity = cap;
        front = 0;
        back = 0;
        size = 0;
        arr = new Node[cap];
    }

    /*
     * This method add new element to the back of Queue and output nothing when
     * success
     * otherwise it will print "Queue Overflow!!!"
     */
    public void enqueue(Node node) {
        if (!isFull()) { // check if Queue is not full
            arr[back] = node; // then set back of Queue to Node
            back++; // and increment back index by 1 for told where next enqueue element to set
            back %= capacity; // but if we just increment back index will overflow array we just use modulo to
                              // make back index circular through some value
            size++; // and increment size by 1
        } else { // but if Queue is full then we just report error
            System.out.println("Queue Overflow!!!");
        }
    }

    /*
     * This method remove element from the front of Queue and output removed Node
     * when success otherwise it will print "Queue Underflow!!!" and output null
     */
    public Node dequeue() {
        Node out = null;
        if (!isEmpty()) { // check if Queue is not empty
            out = arr[front]; // then we just set output to be first element of Queue
            arr[front] = null; // and set first element to be null
            front++; // and move first element to the next one
            front %= capacity; // similiar to enqueue we use modulo to avoid overflow
            size--; // and decrement size by 1
        } else {// but if Queue is empty then we just report error
            System.out.println("Queue Underflow!!!");
        }
        return out; // return removed element btw it will be null when queue is empty
    }

    /*
     * This method return status of Queue that empty or not
     * Return will be true if Queue is empty or false otherwise
     */
    public boolean isEmpty() {
        return size == 0; // empty mean no element in Queue
    }

    /*
     * This method return status of Stack that full or not
     * Return will be true if stack is full or false otherwise
     */
    public boolean isFull() {
        return size == capacity; // full mean we cannot exceed capacity anymore
    }

    /*
     * This method shown what current indicies value inside Queue
     */
    public void printCircularIndices() {
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    /*
     * This method use to visualize structure of Queue
     */
    public void printQueue() {
        if (!isEmpty()) { // check if Queue is not empty
            System.out.print("[Front] ");
            for (int i = front; i - front < size; ++i) { // from printCircularIndices shown that we have some
                                                         // circumstance that front index is behind back, we can use
                                                         // conditional and then for-loop but it easier to use
                                                         // arithmetic to solve this problem by loop from front to
                                                         // front+size-1 and use modulo every index to make sure we are
                                                         // not access element that overflow
                System.out.print(arr[i % capacity].data + " ");
            }
            System.out.println("[Back]");
        } else { // but when Queue is empty we just print
            System.out.println("Empty Queue!!!");
        }
    }
}
