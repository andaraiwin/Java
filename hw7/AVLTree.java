public class AVLTree extends BSTree {
    public void singleRotateFromLeft(Node y) {
        /*
         * This derives from the singleRotateFromLeft method
         */
        super.singleRotateFromLeft(y);
    }

    public void singleRotateFromRight(Node y) {
        /*
         * This derives from the singleRotateFromRight method
         */
        super.singleRotateFromRight(y);
    }

    public void doubleRotateFromLeft(Node y) {
        /*
         * This derives from the doubleleRotateFromLeft method
         */
        super.doubleRotateFromLeft(y);
    }

    public void doubleRotateFromRight(Node y) {
        /*
         * This derives from the doubleleRotateFromRight method
         */
        super.doubleRotateFromRight(y);
    }

    public static void rebalance(AVLTree tree, Node node) {
        if (node == null)
            return;
        int balanceFactor = height(node.right) - height(node.left);
        if (Math.abs(balanceFactor) > 1) {
            if (balanceFactor < 0 && node.left != null) { // left-heavy
                if (height(node.left.right) - height(node.left.left) < 0) {
                    System.out.println("Perform SingleRotationFromLeft(Node " + node.key + ")");
                    tree.singleRotateFromLeft(node);
                } else {
                    System.out.println("Perform DoubleRotationFromLeft(Node " + node.key + ")");
                    tree.doubleRotateFromLeft(node);
                }
            } else if (node.right != null) { // right-heavy
                if (node.right != null && height(node.right.right) - height(node.right.left) < 0) {
                    System.out.println("Perform DoubleRotationFromRight(Node " + node.key + ")");
                    tree.doubleRotateFromRight(node);

                } else {
                    System.out.println("Perform SingleRotationFromRight(Node " + node.key + ")");
                    tree.singleRotateFromRight(node);
                }
            }
        }
    }

    // This function is complete, no need to edit
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance() function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {// Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            } else {
                insert(tree, node.left, key);
            }
        } else { // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            } else {
                insert(tree, node.right, key);
            }
        }
        rebalance(tree, node);
    }

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) {
            Node successor, parent;
            if (root.right == null && root.left == null) {
                successor = null;
                parent = null;
            } else if (root.right == null && root.left != null) {
                successor = findMax(root.left);
                parent = successor.parent;
                BSTree.delete(successor);
                successor.left = root.left;
                if (successor.left != null)
                    successor.left.parent = successor;
            } else {
                successor = findMin(root.right);
                parent = successor.parent;
                BSTree.delete(successor);
                successor.left = root.left;
                if (successor.left != null)
                    successor.left.parent = successor;
                successor.right = root.right;
                if (successor.right != null)
                    successor.right.parent = successor;
            }

            if (successor != null) {
                successor.parent = null;
            }
            if (parent != null && parent.key == key)
                parent = successor;
            root = successor;
            while (parent != null) {
                rebalance(this, parent);
                parent = parent.parent;
            }
        } else {
            delete(this, find(key));
        }
    }

    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void delete(AVLTree tree, Node node) {
        Node successor, parent;
        if (node == null) {
            System.out.println("Key not found!!!");
            return;
        } else if (node.right == null && node.left == null) {
            successor = null;
            parent = node.parent;
        } else if (node.right == null && node.left != null) {
            successor = findMax(node.left);
            parent = successor.parent;
            BSTree.delete(successor);
            successor.left = node.left;
            if (node.left != null)
                successor.left.parent = successor;
        } else {
            successor = findMin(node.right);
            parent = successor.parent;
            BSTree.delete(successor);
            successor.left = node.left;
            if (node.left != null)
                successor.left.parent = successor;
            successor.right = node.right;
            if (node.right != null)
                successor.right.parent = successor;
        }

        if (node.parent != null) {
            if (node.parent.left == node) {
                node.parent.left = successor;
            } else {
                node.parent.right = successor;
            }
        }

        if (successor != null)
            successor.parent = node.parent;
        if (parent == node)
            parent = successor;
        while (parent != null) {
            rebalance(tree, parent);
            parent = parent.parent;
        }

        node.parent = null;
        node.left = null;
        node.right = null;
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

    // This function is complete, no need to edit
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

    public static boolean isMergeable(Node r1, Node r2) {
        return findMax(r1).key < findMin(r2).key;// Fix this
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t) {
        int balanceFactor = height(r1) - height(r2);
        if (Math.abs(balanceFactor) <= 1) {
            return BSTree.mergeWithRoot(r1, r2, t);
        } else if (balanceFactor > 1) {
            Node c = mergeWithRoot(r1.right, r2, t);
            r1.right = c;
            c.parent = r1;

            AVLTree tree_new = new AVLTree();
            tree_new.root = r1;
            tree_new.root.parent = null;
            rebalance(tree_new, r1);
            tree_new.root.parent = r1.parent;
            return tree_new.root;
        } else if (balanceFactor < -1) {
            Node r_new = mergeWithRoot(r1, r2.left, t);
            r2.left = r_new;
            r_new.parent = r2;

            AVLTree tree_new = new AVLTree();
            tree_new.root = r2;
            tree_new.root.parent = null;
            rebalance(tree_new, r2);
            tree_new.root.parent = r2.parent;
            return tree_new.root;
        }
        return null;
    }

    public void merge(AVLTree tree2) {
        if (isMergeable(this.root, tree2.root)) {
            Node root_new = findMax(root);
            delete(root_new.key);
            root = mergeWithRoot(root, tree2.root, root_new);
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
    }

    // Fix this function
    public Node[] split(int key) {
        return split(root, key); // This is incorrect, fix this by calling the static split
    }

    // Fix this function
    public static Node[] split(Node r, int key) {
        Node[] arr = new Node[2];
        // AVLTree tree_new = new AVLTree();
        if (r == null)
            return arr;
        else if (r.key > key) {
            arr = split(r.left, key);
            Node t = new Node(r.key);
            arr[1] = mergeWithRoot(arr[1], r.right, t);

            // AVLTree tree_new = new AVLTree();
            // tree_new.root = arr[1];
            // tree_new.root.parent = null;
            // rebalance(tree_new, tree_new.root);
            // arr[1] = tree_new.root;
            return arr;
        } else {
            arr = split(r.right, key);
            Node t = new Node(r.key);
            arr[0] = mergeWithRoot(r.left, arr[0], t);

            // AVLTree tree_new = new AVLTree();
            // tree_new.root = arr[0];
            // tree_new.root.parent = null;
            // rebalance(tree_new, tree_new.root);
            // arr[0] = tree_new.root;
            return arr;
        }
    }

    // Use this function to check the node height
    // This function is complete, no need to edit
    public static int height(Node node) {
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }

    public AVLTree() {
    } // Dummy Constructor, no need to edit
}