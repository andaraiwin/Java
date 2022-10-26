public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;

    public DoublyLinkedList(String name) {
        this.listName = name;
    }

    public void popBack() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            tail = tail.previous;
            if (tail != null) // special case when last element popback
                tail.next = null;
            else // becuz we want to declare head to be empty as tail
                head = null;
        }
    }

    public void popFront() {
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            head = head.next;
            if (head != null) // similiar to popback
                head.previous = null;
            else
                head = null;
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
            return tail;
        }
    }

    public void pushFront(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else { // change head to node
            node.previous = null;
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else { // similiar to pushfront
            node.previous = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }

    public Node findNode(int id) {
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) { // ordinary iteration
                if (current.student_id == id)
                    return current;
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }

    public Node eraseNode(int id) {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) {
                if (current.student_id == id) {
                    if (current == head && current == tail) { // when only one element in list
                        head = null;
                        tail = null;
                    } else if (current == head) { // easier to not rewrite
                        popFront();
                    } else if (current == tail) {
                        popBack();
                    } else { // disconnect with current node
                        current.previous.next = current.next;
                        current.next.previous = current.previous;
                    }
                    return current;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }

    public void addNodeAfter(Node node1, Node node2) {
        Node current = head;
        while (current != null) {
            if (node1 == current) {
                if (current == tail) {
                    pushBack(node2);
                } else { // change next element of node1 to node2 and node2 to old next
                    node2.next = current.next;
                    node2.previous = current;
                    current.next.previous = node2;
                    current.next = node2;
                }
                return;
            }
            current = current.next;
        }
    }

    public void addNodeBefore(Node node1, Node node2) {
        Node current = head;
        while (current != null) {
            if (node1 == current) {
                if (current == head) {
                    pushFront(node2);
                } else { // similiar to addnodeafter but opposite
                    node2.next = current;
                    node2.previous = current.previous;
                    current.previous.next = node2;
                    current.previous = node2;
                }
                return;
            }
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void merge(DoublyLinkedList list) {
        if (isEmpty() || list.isEmpty()) // we dont want to merge empty list right?
            return;
        list.head.previous = tail;
        tail.next = list.head;
    }

    // This may be useful for you for implementing printStructure()
    public void printStructure() {
        Node current = head;
        System.out.print(listName + ": head <-> ");
        while (current != null) {
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }

    public Node whoGotHighestGPA() {
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node max = tail, current = tail;
            double maxGpa = Double.MIN_VALUE;
            while (current != null) { // ordinary iteration
                if (current.gpa > maxGpa) {
                    maxGpa = current.gpa;
                    max = current;
                }
                current = current.previous;
            }
            return max;
        }
    }

}