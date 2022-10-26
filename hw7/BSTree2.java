public class BSTree2 extends BTreePrinter {
    Node root;

    // Implement this function using iterative method
    // Do not use recursion
    public Node find(int search_key) {
        Node current = root;
        while (current != null) {
            if (current.key == search_key) // If found then return the node and this will stop the recursion process
                return current;
            else if (current.key > search_key) // If less use recursion to find left side
                current = current.left;
            else // If greater use recursion to find right side
                current = current.right;
        }
        return null;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin() {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax() {
        Node current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (current != null) {
            if (current.key == key) {
                System.out.println("Duplicated key!!!");
                return;
            } else if (key < current.key) { // ถ้าค่าที่ต้องการหา มีค่าน้อยกว่าค่า node ปัจจุบัน
                if (current.left == null) {
                    current.left = node;
                    return;
                } else
                    current = current.left;
            } else {// แต่ถ้าถ้าค่าที่ต้องการหา มีค่ามากกว่าค่า node ปัจจุบัน
                if (current.right == null) {
                    current.right = node;
                    return;
                } else // แต่ถ้าไม่ให้หาขวาต่อไปจนกว่าจะเจอ
                    current = current.right;
            }
        }
    }

    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
}