package trees;

import java.util.ArrayList;
import java.util.List;

public class PrintNodesDistanceKFromLeaf {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private void printKDistLeaf(Node root, int k, List<Integer> path, List<Boolean> visited, int pathIndex) {
        if (root == null) {
            return;
        }

        path.add(pathIndex, root.data);
        visited.add(pathIndex, false);
        pathIndex++;

        // identify leaf
        if (root.left == null && root.right == null) {
            if (pathIndex - k - 1 >= 0 && !visited.get(pathIndex - k - 1)) {
                System.out.println(path.get(pathIndex - k - 1));
                visited.add(pathIndex - k - 1, true);
            }
            return;
        }

        // traverse left and right
        printKDistLeaf(root.left, k, path, visited, pathIndex);
        printKDistLeaf(root.right, k, path, visited, pathIndex);
    }

    private void printKDistantfromLeaf(Node node, int k) {
        printKDistLeaf(node, k, new ArrayList<>(), new ArrayList<>(), 0);
    }

    public static void main(String args[]) {
        PrintNodesDistanceKFromLeaf p = new PrintNodesDistanceKFromLeaf();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        p.printKDistantfromLeaf(root, 2);
    }
}
