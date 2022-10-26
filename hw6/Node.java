
public class Node {
    Node left;
    Node right;
    Node parent;
    int key;

    public Node(int key) {
        this.key = key;
    }

    public static int height(Node node) {
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static int size(Node node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public static Node leftDescendant(Node node) {
        if (node.left == null)
            return node;
        else
            return leftDescendant(node.left);
    }

}
