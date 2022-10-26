public class BSTree extends BTreePrinter {
    Node root;

    public void singleRotateFromLeft(Node y) {
        Node successor = y.left;
        if (successor == null)
            return;
        else if (y != root) {
            if (y.parent.left == y)
                y.parent.left = successor;
            else
                y.parent.right = successor;
            successor.parent = y.parent;

            y.left = successor.right;
            if (y.left != null)
                y.left.parent = y;

            successor.right = y;
            y.parent = successor;
        } else {
            root = successor;
            successor.parent = null;

            y.left = successor.right;
            if (y.left != null)
                y.left.parent = y;

            successor.right = y;
            y.parent = successor;
        }
    }

    public void singleRotateFromRight(Node y) {
        Node successor = y.right;
        if (successor == null)
            return;
        if (y != root) {
            if (y.parent.left == y)
                y.parent.left = successor;
            else
                y.parent.right = successor;
            successor.parent = y.parent;

            y.right = successor.left;
            if (y.right != null)
                y.right.parent = y;

            successor.left = y;
            y.parent = successor;
        } else {
            root = successor;
            successor.parent = null;

            y.right = root.left;
            if (y.right != null)
                y.right.parent = y;

            successor.left = y;
            y.parent = root;
        }
    }

    public void doubleRotateFromLeft(Node y) {
        singleRotateFromRight(y.left);
        singleRotateFromLeft(y);
    }

    public void doubleRotateFromRight(Node y) {
        singleRotateFromLeft(y.right);
        singleRotateFromRight(y);
    }

    public Node find(int search_key) {
        return find(root, search_key);
    }

    public static Node find(Node node, int search_key) {
        if (node == null)
            return null; // If search end but havent found yet return null and this will stop the
                         // recursion process
        else if (node.key == search_key) // If found then return the node and this will stop the recursion process
            return node;
        else if (node.key > search_key) // If less use recursion to find left side
            return find(node.left, search_key);
        else // If greater use recursion to find right side
            return find(node.right, search_key);
    }

    public static Node findMin(Node node) {
        if (node.left == null) // ถ้าด้านซ้ายว่างเปล่าของ node นั้นให้ return node นั้นเลย
            return node;
        else // แต่ถ้าไม่ว่างให้ไป node พยายามหา min เรื่อยๆ โดยการหา min จาก node ด้านซ้าย
            return findMin(node.left);
    }

    public static Node findMax(Node node) {
        if (node.right == null)
            return node;
        else
            return findMax(node.right);
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Main.insert(root, key);
        }
    }

    public void delete(int key) {
        // it's straightforward we try to cover all possiblility no need to explain here
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) {
            Node successor = root;
            if (root.right == null && root.left == null) {
                successor = null;
            } else if (root.right != null && root.left == null) {
                successor = findMin(root.right);
                delete(successor);
                successor.right = root.right;
            } else {
                successor = findMax(root.left);
                delete(successor);
                successor.left = root.left;
                successor.right = root.right;
            }
            root = successor;
        } else {
            delete(find(key));
        }
    }

    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void delete(Node node) {
        Node successor;
        if (node == null) {
            System.out.println("Key not found!!!");
            return;
        } else if (node.right == null && node.left == null) {
            successor = null;
        } else if (node.right != null && node.left == null) {
            successor = findMin(node.right);
            delete(successor);
            successor.right = node.right;
        } else {
            successor = findMax(node.left);
            delete(successor);
            successor.left = node.left;
            successor.right = node.right;
        }

        if (node.parent != null) {
            if (node.parent.left == node) {
                node.parent.left = successor;
            } else {
                node.parent.right = successor;
            }
        }
        if (successor != null) {
            successor.parent = node.parent;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
    }

    public static boolean isMergeable(Node r1, Node r2) {
        return r1 == null || r2 == null || (findMax(r1).key < findMin(r2).key);// Fix this
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t) {
        if (isMergeable(r1, r2)) {
            t.left = r1;
            t.right = r2;
            if (r1 != null)
                r1.parent = t;
            if (r2 != null)
                r2.parent = t;
            return t;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }

    public void merge(BSTree tree2) {
        if (isMergeable(this.root, tree2.root)) {
            Node t = findMax(this.root);
            delete(t);
            this.root = mergeWithRoot(this.root, tree2.root, t);
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
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