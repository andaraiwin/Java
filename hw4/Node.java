package hw4;

public class Node {
    int shares;
    double price;
    Node next;

    /*
     * This constructor use to create new node that have shares and price
     * for record a transaction
     */
    public Node(int shares, double price) {
        this.shares = shares;
        this.price = price;
    }
}
