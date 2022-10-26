// เนื่องจาก Homework นี้มีการเขียน Comment จากนักศึกษาหลายคนดังนั้นจึงมีการสลับระหว่างภาษาไทยกับภาษาอังกฤษบ้าง จึงขออภัยมา ณ จุดนี้ด้วยครับ
public class Tree extends BTreePrinter { // Fix this
    Node root;

    /*
     * Construct tree with root node
     */
    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
    } // Dummy constructor (No need to edit)

    /*
     * This method use to visualize tree structure by inherit method from
     * BTreePrinter and have a sanity check for a empty tree
     */
    public void printTree() {
        if (root == null)
            System.out.println("Empty tree!!!");
        else
            super.printTree(root);
    }

    /*
     * This method show the value of node and have a sanity check that node is empty
     * or not
     */
    public static void printNode(Node node) {
        if (node == null)
            System.out.println("Node not found!!!");
        else
            System.out.println(node.key);
    }

    /*
     * This is warpper of static method find for recursion purpose
     */
    public Node find(int search_key) {
        return Tree.find(root, search_key);
    }

    /*
     * This method try to find the key from thier descendant and output the matched
     * node if they were exist but output null instead if they not exist
     */
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

    /*
     * This is warpper of static method findMin for recursion purpose
     */
    public Node findMin() {
        return Tree.findMin(root); // Call the recursive version
    }

    /*
     * ใน Method นี้เราจะหาค่าที่น้อยที่สุด
     * โดยการหาด้านซ้ายสุดถ้าด้านซ้ายของ node ปัจจุบันเท่ากับ null แล้ว ให้ return
     * node ปัจจุบัน
     * นั้นแต่ถ้าไม่เท่าให้ไป node ด้านซ้ายต่อไป
     */
    public static Node findMin(Node node) {
        if (node.left == null) // ถ้าด้านซ้ายว่างเปล่าของ node นั้นให้ return node นั้นเลย
            return node;
        else // แต่ถ้าไม่ว่างให้ไป node พยายามหา min เรื่อยๆ โดยการหา min จาก node ด้านซ้าย
            return findMin(node.left);
    }

    /*
     * This is warpper of static method findMax for recursion purpose
     */
    public Node findMax() {
        return Tree.findMax(root); // Call the recursive version
    }

    /*
     * ใน Method นี้เราจะหาค่าที่มากที่สุด
     * โดยการหาด้านขวาสุดถ้าเท่าด้านขวาเท่ากับ null แล้ว ให้ return node
     * นั้นแต่ถ้าไม่เท่าให้ไป node ด้านซ้ายต่อไป
     */
    public static Node findMax(Node node) {
        if (node.right == null)
            return node;
        else
            return findMax(node.right);
    }

    /*
     * This is warpper of static method findClosestLeaf for recursion purpose
     */
    public Node findClosestLeaf(int search_key) {
        if (root == null)
            return null;
        return findClosestLeaf(root, search_key);
    }

    /*
     * ใน Method นี้เราจะหา node ที่มีที่ให้นำ node ใหม่ใส่เข้าไปเป็นบุตร
     * โดยแทนค่าของ node ใหม่ที่จะใส่เข้าไปเป็น search_key โดย method
     * นี้เป็นชิ้นส่วนที่สำคัญส่วนหนึ่งของการ insert
     */
    public static Node findClosestLeaf(Node node, int search_key) {
        if (node.key == search_key) // ถ้าค่าของ node ปัจจุบัน มีค่าเท่ากับ ค่าที่ต้องการหาให้ return node ปัจจุบัน
                                    // เพราะจะมีการใช้ในการเช็คตัวซ้ำในอนาคตต่อไป
            return node;
        else if (search_key < node.key) { // ถ้าค่าที่ต้องการหา มีค่าน้อยกว่าค่า node ปัจจุบัน
            if (node.left == null) // ให้ดูทางซ้ายว่ามีทีไหม ถ้ามีให้ return
                                   // ตัวปัจจุบันเพราะนี่แหละคือตัวที่เราตามหา
                return node;
            else // แต่ถ้าไม่ให้หาทางซ้ายต่อไปจนกว่าจะเจอ
                return findClosestLeaf(node.left, search_key);
        } else {// แต่ถ้าถ้าค่าที่ต้องการหา มีค่ามากกว่าค่า node ปัจจุบัน
            if (node.right == null) // ให้ดูทางขวาว่ามีทีไหม ถ้ามีให้ return
                                    // ตัวปัจจุบันเพราะนี่แหละคือตัวที่เราตามหา
                return node;
            else // แต่ถ้าไม่ให้หาขวาต่อไปจนกว่าจะเจอ
                return findClosestLeaf(node.right, search_key);
        }
    }

    /*
     * ใน Method นี้เราจะหา node ที่มีค่าใกล้กับค่าที่ใส่เข้ามามากที่สุด
     */
    public Node findClosest(int search_key) {
        // Please use while loop to implement this function
        // Try not to use recursion
        Node current, closest;
        closest = current = root; // กำหนดว่า node ที่ใกล้ที่สุดและ node ปัจจุบัน = root
        int min_diff = Integer.MAX_VALUE; // ประกาศค่าผลต่างที่น้อยที่สุด ให้เท่ากับเลขที่มากที่สุดใน integer
                                          // เพราะจะทำให้การเปรียบเทียบเกิดขึ้นกับตัวแรก

        // Use while loop to traverse from root to the closest leaf
        while (current != null) { // ให้ทำเรื่อยๆ ถ้า node ปัจจุบันไม่เท่ากับ null
            if (current.key == search_key) // ถ้าค่าของ node ปัจจุบันมีค่าเท่ากับค่าที่ต้องการหา ให้ return node
                                           // ปัจจุบัน
                return current;
            /*
             * ถ้าผลต่างที่น้อยที่สุดที่เคยหามากับ search_key เทียบกับผลต่าง node
             * ตัวปัจจุบันกับ search_key มีค่าน้อยกว่านั้นอีก ให้ตั้งค่าผลต่างตัวนั้นแหละ
             * เป็นค่าผลต่างที่น้อยที่สุด
             */
            if (Math.abs(search_key - current.key) < min_diff) {
                min_diff = Math.abs(search_key - current.key);
                closest = current;
            }
            /*
             * หลังจากนั้นใดเปลี่ยน node ตัวปัจจุบันเป็น node ตัวลูกของมัน
             * โดยเปรียบเทียบก่อนว่าถ้า search_key insert เข้ามามันควรจะไปอยู่ตรงไหน
             * ซ้ายหรือขวา
             */
            if (search_key < current.key) // ถ้า search_key น้อยกว่าก็ไปทางซ้าย หรือถ้าไม่ก็ไปขวา
                current = current.left;
            else
                current = current.right;
        }
        return closest;
    }

    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    /*
     * ใน Method นี้เราจะใส่ค่าใหม่เข้ามา
     * โดยการสร้าง node ใหม่ให้กับค่าที่เราใส่เข้ามา
     */
    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) { // เช็คกรณี empty tree โดยจะตั้ง root node แทน
            root = node;
            return;
        }

        Node hang = findClosestLeaf(key); // hang ในที่นี้คือการหาว่ามีจุดไหน ที่สามารถเอาไปใส่ได้ไหม
        if (hang.key == key) // ซึ่งถ้า hang ทีค่าเท่ากับ key เรารู้เลยว่ามันมีตัวซ้ำแน่นอน
            System.out.println("Duplicated key!!!");
        else if (hang.key > key) { // แต่ถ้าไม่เท่ากันก็หาที่ใส่ตามสเต็ปคือน้อยกว่าใส่ทางซ้าย ใหญ่กว่าใส่ทางขวา
            hang.left = node;
            node.parent = hang;
        } else {
            hang.right = node;
            node.parent = hang;
        }
    }

    /*
     * This is warpper of static method printPreOrderDFT for recursion purpose
     */
    public void printPreOrderDFT() {
        System.out.print("PreOrder DFT node sequence [ ");
        printPreOrderDFT(root);
        System.out.println("]");
    }

    /*
     * ใน Method นี้เราจะ print ลำดับแบบ DFT Preorder โดยใช้การ recursion
     */
    public static void printPreOrderDFT(Node node) {
        if (node == null) // ตัวหยุด recursion
            return;

        // Preorder คือการแสดงค่าตัวมันเองก่อนแล้วไปค่อยไปทำซ้ำกับ sub-tree ทางซ้าย
        // แล้วไปทางขวา
        System.out.print(node.key + " ");
        printPreOrderDFT(node.left);
        printPreOrderDFT(node.right);
    }

    /*
     * This is warpper of static method printInOrderDFT for recursion purpose
     */
    public void printInOrderDFT() {
        System.out.print("InOrder DFT node sequence [ ");
        printInOrderDFT(root);
        System.out.println("]");
    }

    /*
     * ใน Method นี้เราจะ print ลำดับแบบ DFT Inorder โดยใช้การ recursion
     */
    public static void printInOrderDFT(Node node) {
        if (node == null) // ตัวหยุด recursion
            return;

        // Inorder คือการแสดงค่าของ sub-tree ทางซ้ายก่อน แล้วค่อยแสดงค่าตัวมันเอง
        // แล้วไปทางขวา
        printInOrderDFT(node.left); // โดยมันจะไม่เริ่มทำงานจนกว่า node.left จะเป็น null หรือมันจะเริ่มตัวซ้ายสุด
        System.out.print(node.key + " ");
        printInOrderDFT(node.right);
    }

    /*
     * This is warpper of static method PostOrderDFT for recursion purpose
     */
    public void printPostOrderDFT() {
        System.out.print("PostOrder DFT node sequence [ ");
        printPostOrderDFT(root);
        System.out.println("]");
    }

    /*
     * ใน Method นี้เราจะ print ลำดับแบบ DFT Postorder โดยใช้การ recursion
     */
    public static void printPostOrderDFT(Node node) {
        if (node == null) // ตัวหยุด recursion
            return;

        // Postorder คือการแสดงค่าของ sub-tree ทางซ้ายก่อน แล้วไปทางขวา
        // แล้วค่อยแสดงค่าตัวมันเอง
        printPostOrderDFT(node.left);// โดยจะมีความคล้ายกับ Inorder คือมันจะไม่เริ่มทำงานเลยถ้า node.left ไม่เป็น
                                     // null แต่ในกรณีของ Postorder มันจะไม่เริ่มทำงานเมื่อ node.right ไม่เป็น null
                                     // ดังนั้นมันจะเริ่มตัวขวาสุดก่อน
        printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }

    /*
     * This method will output height of any tree
     */
    public static int height(Node node) {
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if (node == null) // recursion terminator
            return -1;
        // depth of tree = maxiumum of height of sub-tree + 1
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /*
     * This method will output size of any tree
     */
    public static int size(Node node) {
        if (node == null) // recursion terminator
            return 0;
        // size of tree = sizeof left sub-tree + size of right sub-tree + 1
        return 1 + size(node.left) + size(node.right);
    }

    /*
     * This method will depth from node to root of any tree
     */
    public static int depth(Node root, Node node) {
        if (root == node)
            return 0;
        // climb the way up to parent till parent is root
        return 1 + depth(root, node.parent);

    }

    public int height() { // Tree height
        // Hint: call the static function
        return height(root);
    }

    public int size() { // Tree size
        // Hint: call the static function
        return size(root);
    }

    public int depth() { // Tree depth
        // Hint: call the static function
        return height(root);
    }

    /*
     * This is warpper of static method findKthSmallest for recursion purpose
     */
    public Node findKthSmallest(int k) {
        return findKthSmallest(root, k); // Call the recursive version
    }

    // find Kth smallest node in element (Kth smallest mean how small the node are
    // from smallest node if 1 that node is smallest)
    public static Node findKthSmallest(Node node, int k) {
        // Kth smallest element of left sub-tree size is current node because
        // left-subtree will alaways smallest that current node and if we try to reach
        // smallest element greater than it's size by one tho it will be thier parent as
        // that...
        if (k == size(node.left) + 1) {
            return node;

        } else if (k < size(node.left) + 1) { // But when k is less than left sub-tree size that we sure that Kth
                                              // smallest will be inside there, so traverse to that subtree
            return findKthSmallest(node.left, k);
        } else { // But when k is greater than left-subtree + 1 then we sure that Kth will be in
                 // right sub-tree but first we need subtract k by size of node left + 1 because
                 // we try to reach to smallest of right-subtree that has a smaller size than
                 // current tree and then traverse to right subtree
            return findKthSmallest(node.right, k - size(node.left) - 1);
        }
    }

    // imagine sort all elements in tree into sorted array find next element mean
    // we try to find next element from current value to next value
    public static Node findNext(Node node) {
        // if right sub-tree is exist then the element is left-most descentdant or
        // smallest child of right-subtree else it will be thier parent that have a
        // value greater than current node
        if (node.right != null)
            return leftDescendant(node.right);
        else
            return rightAncestor(node);
    }

    public static Node leftDescendant(Node node) {// Case 1 (findMin)
        return findMin(node);
    }

    // right ancestor is find the ancestor that a greater in value than given node
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        if (node.parent == null)
            return null;
        else if (node.key < node.parent.key)
            return node.parent;
        else
            return rightAncestor(node.parent);
    }

    // perform to find a range of elements in tree, output is list of element that
    // have a value inside the given range
    public List rangeSearch(int x, int y) {
        var list = new List(100);
        var current = findClosest(x);
        while (current != null && current.key <= y) { // iterate from node that have a value closet to x till last node
                                                      // that have a value less than y
            if (current.key >= x)
                list.append(current);
            current = findNext(current);
        }
        return list;
    }

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) { // 6 cases
        // it's straightforward we try to cover all possiblility no need to explain here
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.right == null) {
                root = root.left;
                root.parent.left = null;
                root.left = null;
            } else { // but this one is more special because if we want to delete node that have a
                     // child will must promote their child to their position according to class we
                     // try to match their rule that
                     // 1) if they have a right sub-tree promote least element in right sub-tree
                     // 2) if they do not just replaced with left sub-tree which is above
                     // 3) if they do have anything just go away
                var replacer = findMin(root.right);
                Tree.delete(replacer);
                replacer.left = root.left;
                if (root.left != null)
                    root.left.parent = replacer;
                replacer.right = root.right;
                if (root.right != null)
                    root.right.parent = replacer;
                root = replacer;
            }
        } else {
            Tree.delete(find(key));
        }
    }

    // Use this function to delete non-root nodes
    public static void delete(Node node) { // 7
        // it's straightforward we try to cover all possiblility no need to explain here
        Node successor;
        if (node == null) {
            System.out.println("Key not found!!!");
            return;
        } else if (node.right != null && node.left != null) {
            // this one is more special because if we want to deletenode that have a child
            // will must promote their child to their position according to class we try to
            // match their rule that
            // 1) if they have a right sub-tree promote least element in right sub-tree
            // 2) if they do not just replaced with left sub-tree which is above
            // 3) if they do have anything just go away
            successor = findMin(node.right);
            delete(successor);
            successor.left = node.left;
            successor.right = node.right;
            if (successor.left != null)
                successor.left.parent = successor;
            if (successor.right != null)
                successor.right.parent = successor;
        } else if (node.right != null) {
            successor = node.right;
        } else if (node.left != null) {
            successor = node.left;
        } else {
            if (node.parent.left == node)
                node.parent.left = null;
            else
                node.parent.right = null;
            node.parent = null;
            return;
        }

        successor.parent = node.parent;
        if (node.parent.left == node)
            node.parent.left = successor;
        else
            node.parent.right = successor;

        node.left = null;
        node.right = null;
        node.parent = null;
    }
}
