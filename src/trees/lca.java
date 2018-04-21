package trees;

public class lca {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node leastCommonAncestor(int v1, int v2, Node root) {

        if (root == null) {
            return null;
        }

        if (root.data > v1 && root.data > v2) {
            return leastCommonAncestor(v1, v2, root.left);
        }

        if (root.data < v1 && root.data < v2) {
            return leastCommonAncestor(v1, v2, root.right);
        }

        boolean isV1Present = (v1 < v2) ? checkIfValuesPresent(root.left, v1) : checkIfValuesPresent(root.right, v1);
        boolean isV2Present = (v1 < v2) ? checkIfValuesPresent(root.right, v2) : checkIfValuesPresent(root.left, v1);

        return (isV1Present && isV2Present) ? root : null;
    }

    private boolean checkIfValuesPresent(Node root, int v1) {
        if (root == null) {
            return false;
        }

        if (root.data == v1) {
            return true;
        }

        if (checkIfValuesPresent(root.left, v1)) {
            return true;
        }

        if (checkIfValuesPresent(root.right, v1)) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        lca bt = new lca();
        Node node = new Node(15);
        node.left = new Node(10);
        node.left.left = new Node(5);
        node.left.right = new Node(13);
        node.left.right.left = new Node(12);
        node.left.right.right = new Node(14);
        node.right = new Node(20);
        System.out.println(bt.leastCommonAncestor(5, 16, node).data);
    }
}
