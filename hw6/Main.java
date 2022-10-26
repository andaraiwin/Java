
public class Main {

    public static Tree constructTree1() { // No parent
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.left.right = new Node(2);
        root.right = new Node(7);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);
        return new Tree(root);
    }

    public static Tree constructTree2() { // No parent
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(10);
        root.left.left.right = new Node(20);
        root.right = new Node(70);
        root.right.right = new Node(90);
        root.right.right.left = new Node(80);
        root.right.right.right = new Node(99);
        return new Tree(root);
    }

    public static Tree constructTree3() { // With parent
        Tree tree = new Tree();
        int[] keyList = { 5, 3, 1, 2, 7, 9, 10, 8 };
        for (int i = 0; i < keyList.length; i++)
            Main.insert(tree, tree.root, keyList[i]);// This function is hidden from students
        return tree;
    }

    public static Tree constructTree4() {
        Tree tree = new Tree();
        int[] keyList = { 5, 3, 1, 7, 9, 10, 8 };
        for (int i = 0; i < keyList.length; i++)
            Main.insert(tree, tree.root, keyList[i]);// This function is hidden from students
        return tree;
    }

    public static Tree constructTree5() {
        Tree tree = new Tree();
        int[] keyList = { 5, 2, 3, 9, 1, 10, 8, 7 };
        for (int i = 0; i < keyList.length; i++)
            tree.insert(keyList[i]);// This function is hidden from students
        return tree;
    }

    public static Tree constructTree6() {
        Tree tree = new Tree();
        int[] keyList = { 6, 7, 9, 5, 3, 4, 10, 8, 1 };
        for (int i = 0; i < keyList.length; i++)
            tree.insert(keyList[i]);// This function is hidden from students
        return tree;
    }

    public static Tree constructTree7() {
        Tree tree = new Tree();
        int[] keyList = { 5, 3, 7 };
        for (int i = 0; i < keyList.length; i++)
            tree.insert(keyList[i]);// This function is hidden from students
        return tree;
    }

    public static Tree constructTree8() {
        Tree tree = new Tree();
        int[] keyList = { 5, 3, 7, 1, 6, 9, 2, 8, 10 };
        for (int i = 0; i < keyList.length; i++)
            tree.insert(keyList[i]);// This function is hidden from students
        return tree;
    }

    public static Node find(Node node, int search_key) {
        // This function is hidden from students
        return null;
    }

    public static void insert(Tree t, Node current, int search_key) {
        // This function is hidden from students
    }

    public static void main(String[] args) {

        // Tree tree = new Tree();
        // tree.printTree();

        // tree = Main.constructTree1();
        // tree.printTree();

        // Node node = tree.findClosestLeaf(9);
        // Tree.printNode(node);

        // Tree tree = Main.constructTree1();
        // tree.printTree();
        // Node node = tree.findClosest(-999);
        // Tree.printNode(node);
        // node = tree.findClosest(999);
        // Tree.printNode(node);

        // Tree tree = Main.constructTree1();
        // tree.printTree();

        // Node node = tree.find(3);
        // Tree.printNode(node);

        // node = tree.find(4);
        // Tree.printNode(node);

        // node = tree.findMin();
        // Tree.printNode(node);
        // node = tree.findMax();
        // Tree.printNode(node);

        // Tree tree = new Tree();
        // int[] keyList = { 5, 3, 1, 2, 7, 9, 10, 10, 8 };
        // for (int i = 0; i < keyList.length; i++)
        // tree.insert(keyList[i]);
        // tree.printTree();

        // tree.printPreOrderDFT();
        // tree.printInOrderDFT();
        // tree.printPostOrderDFT();

        /*
         * Tree tree = Main.constructTree3();
         * tree.printTree();
         * Node node = Main.find(tree.root, 7);
         * System.out.println("Node "+node.key+"'s Size = "+Tree.size(node));
         * System.out.println("Node "+node.key+"'s Depth = "+Tree.depth(tree.root,
         * node));
         * System.out.println("Node "+node.key+"'s Height = "+Tree.height(node));
         */
        /*
         * Tree tree = constructTree3();
         * 
         * tree.printTree();
         * System.out.println("Tree Size = "+tree.size());
         * System.out.println("Tree Depth = "+tree.depth());
         * System.out.println("Tree Height = "+tree.height());
         */
        /*
         * Tree tree = new Tree();
         * System.out.println("Tree Size = "+tree.size());
         * System.out.println("Tree Depth = "+tree.depth());
         * System.out.println("Tree Height = "+tree.height());
         * Main.insert(tree, tree.root, 55);
         * System.out.println("Tree Size = "+tree.size());
         * System.out.println("Tree Depth = "+tree.depth());
         * System.out.println("Tree Height = "+tree.height());
         */

        /*
         * Tree tree = Main.constructTree3();
         * tree.printTree();
         * Node n;
         * int[] data = {5, 7, 1, 9, 8};
         * int s, h, d;
         * for (int i=0; i<data.length; i++){
         * n = Main.find(tree.root, data[i]);
         * s = Tree.size(n);
         * h = Tree.height(n);
         * d = Tree.depth(tree.root, n);
         * System.out.println("Node key "+n.key+" : size="+s+" height="+h+" depth="+d);
         * }
         */

        // Tree tree = Main.constructTree5();
        // tree.printTree();
        // tree.printInOrderDFT();
        // Node node = tree.findKthSmallest(6);
        // System.out.println("The Node key " + node.key + " is the 6th smallest node");
        // // 8

        // Tree tree = Main.constructTree6();
        // tree.printTree();
        // List list = tree.rangeSearch(4, 8);
        // list.printList();

        // Tree tree = Main.constructTree7();
        // tree.printTree();
        // tree.delete(0);
        // System.out.println("-----");
        // tree.delete(5);
        // tree.printTree();
        // tree.delete(7);
        // tree.printTree();
        // tree.delete(3);
        // System.out.println("-----");
        // tree.printTree();
        // tree.delete(0);
        // System.out.println("-----");

        /*
         * Tree tree = Main.constructTree7();
         * tree.printTree();
         * tree.delete(0);
         * System.out.println("-----");
         * tree.delete(3); tree.printTree();
         * tree.delete(7); tree.printTree();
         * tree.delete(5);
         * System.out.println("-----");
         * tree.printTree();
         * tree.delete(0);
         * System.out.println("-----");
         */

        // Tree tree = Main.constructTree8();
        // tree.printTree();
        // tree.delete(10);
        // tree.printTree();
        // tree.delete(9);
        // tree.printTree();

        Tree tree = Main.constructTree8();
        tree.printTree();
        tree.delete(1);
        tree.printTree();
        tree.delete(2);
        tree.printTree();
        tree.delete(3);
        tree.printTree();

        tree = Main.constructTree8();
        tree.printTree();
        tree.delete(6);
        tree.printTree();
        tree.delete(7);
        tree.printTree();

        tree = Main.constructTree8();
        tree.printTree();
        tree.delete(9);
        tree.printTree();
        tree.delete(7);
        tree.printTree();

    }
}
