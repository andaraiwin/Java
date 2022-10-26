public class SinglyLinkedList {
    Node head;
    String listName;

    public SinglyLinkedList(String name) {
        listName = name;
    }

    public void popBack() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            if (head.next == null) // check if it was last element then declare this list empty
                head = null;
            else { // remove any link from last one
                while (head.next.next != null) {
                    head = head.next;
                }
                head.next = null;
            }
        }
    }

    public void popFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            if (head.next == null) // check if it was last element then declare this list empty
                head = null;
            else { // changed head to the next one
                head = head.next;
            }
        }
    }

    public Node topFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }

    public Node topBack() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node iter = head;
            while (iter.next != null) { // loop till it was the last one
                iter = iter.next;
            }
            return iter;
        }
    }

    public void pushFront(Node node) {
        if (isEmpty()) { // if empty declare it was a head
            head = node;
            head.next = null;
        } else { // add link and change a head
            node.next = head;
            head = node;
        }
    }

    public void pushBack(Node node) {
        if (isEmpty()) { // do same thing -> not rewrite
            pushFront(node);
        } else { // change next element of last to new
            Node iter = head;
            while (iter.next != null) { // loop till end
                iter = iter.next;
            }
            node.next = null;
            iter.next = node;
        }
    }

    public Node findNode(int id) {
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) { // loop till end
                if (current.student_id == id) // if found return it
                    return current;
                current = current.next; // else move to the next one
            }
            return new Node("Student Not Found!");
        }
    }

    public Node eraseNode(int id) {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head, p_current = null;
            while (current != null) {
                if (current.student_id == id) {
                    if (current == head && current.next == null) { // when only one element in list
                        head = null;
                    } else if (current == head) { // easier to not rewrite
                        popFront();
                    } else if (current.next == null) {
                        popBack();
                    } else { // disconnect with current node
                        p_current.next = current.next;
                    }
                    return current;
                }
                p_current = current;
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }

    public void addNodeAfter(Node node1, Node node2) {
        Node current = head;
        while (current != null) {
            if (node1 == current) {
                if (current.next == null) { // reuse code;
                    pushBack(node2);
                } else { // change next element of node1 to node2 and node2 to old next
                    node2.next = current.next;
                    current.next = node2;
                }
                return;
            }
            current = current.next;
        }
    }

    public void addNodeBefore(Node node1, Node node2) {
        Node current = head, p_current = head;
        while (current != null) {
            if (node1 == current) {
                if (current == head) {
                    pushFront(node2);
                } else { // change previous element next link to node2
                    p_current.next = node2;
                    node2.next = node1;
                }
                return;
            }
            p_current = current;
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void merge(SinglyLinkedList list) {
        if (isEmpty() || list.isEmpty()) // we dont want to merge empty list right?
            return;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = list.head;
    }

    public void printStructure() {
        Node current = head;
        System.out.print(listName + ": head -> ");
        while (current != null) {
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node whoGotHighestGPA() {
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            int i = 0, iMax = -1;
            double maxGpa = Double.MIN_VALUE;
            Node max = head, current = max;
            while (current != null) { // ordinary iteration
                if (current.gpa >= maxGpa && i > iMax) { // due to problem require most farthest then we introduce i to
                                                         // make it farthest when equal
                    maxGpa = current.gpa;
                    max = current;
                    iMax = i;
                }
                current = current.next;
                i++;
            }
            return max;
        }
    }

}