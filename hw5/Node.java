package hw5;

public class Node extends BTreePrinter {

    Node left;
    Node right;
    int data;

    /*
     * This is a constructor of Node use to initialize Node with data
     */
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /*
     * This method use to visualize tree structure by inherit method from
     * BTreePrinter
     */
    public void printTree() {
        super.printTree(this);
    }

    /*
     * This method print Breadth-first Traversal sequence
     * by using Queue, mechanism is we will enqueue root node first and dequeue it
     * and check they have children or not if yes we enqueue left first then right
     * if they only have one child we will enqueue the only one they had
     * and loop the process on queue until queue empty, that means all node
     * with same depth will print first and then next depth level will go after
     */
    public void printBFT() {
        Queue q = new Queue(50);
        q.enqueue(this);
        System.out.print("BFT node sequence [ ");
        while (!q.isEmpty()) { // loop until queue is empty
            var current = q.dequeue(); // dequeue element from queue
            if (current.left != null) // we check left child first
                q.enqueue(current.left); // if they exist enqueue them
            if (current.right != null) // and then right child
                q.enqueue(current.right); // if they exist enqueue them too
            System.out.print(current.data + " "); // print out current node data
        }
        System.out.println("]");
    }

    /*
     * This method print Depth-first Traversal sequence
     * similiar to printBFT but we using Stack this time, mechanism is we will push
     * root node first and pop it
     * and check they have children or not if yes we push right first then left
     * (from structure of stack of course~)
     * if they only have one child we will push the only one they had
     * and loop the process on stack until stack is empty, that means we will print
     * most shallow until deepest of some branch and then another
     */
    public void printDFT() {
        Stack q = new Stack(50);
        q.push(this);
        System.out.print("DFT node sequence [ ");
        while (!q.isEmpty()) { // loop until stack is empty
            var current = q.pop(); // pop element from queue
            if (current.right != null) // we check right child first
                q.push(current.right); // if they exist push them
            if (current.left != null) // and then left child
                q.push(current.left); // if they exist enqueue them too
            System.out.print(current.data + " "); // print out current node data
        }
        System.out.println("]");
    }
}
