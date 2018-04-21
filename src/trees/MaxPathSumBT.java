package trees;

public class MaxPathSumBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    class Result {
        int val;
    }

    public int maxPathSum(Node root) {
        Result rs = new Result();
        rs.val = Integer.MIN_VALUE;
        maxPathSum(root, rs);
        return rs.val;
    }

    private int maxPathSum(Node root, Result res) {
        /**
         * 1. Node
         * 2. Node + left
         * 3. Node + right
         * 4. Node + left + right
         */

        if (root == null) {
            return 0;
        }

        int l = maxPathSum(root.left, res);
        int r = maxPathSum(root.right, res);

        int subtreeMax = Math.max(root.data, Math.max(l, r) + root.data);
        res.val = Math.max(Math.max(subtreeMax, root.data + l + r), res.val);

        return subtreeMax;
    }

    public static void main(String args[]) {
        MaxPathSumBT mBT = new MaxPathSumBT();
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println(mBT.maxPathSum(root));
    }
}
