package trees;

public class ConstructBSTFromPreorder {
    /**
     * Algorithm:
     * 1. In preorder, the first element in the array is always the root
     * 2. move the index. The next index should either go to the right or left sub tree
     * 3. go to left subtree if:
     * key < root and > min
     * right subtree:
     * key > current root < max val
     * 4. else we found our leaf and return
     */


    static class Node {
        int data;
        Node left, right;

        public Node(int num) {
            this.data = num;
        }
    }

    static int index;

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    private Node createBSTFromPreOrder(int a[], int min, int max) {

        if (index == a.length) {
            return null;
        }

        Node root = new Node(a[index]);

        if (root.data < min || root.data > max) {
            return null;
        }

        index++;
        root.left = createBSTFromPreOrder(a, min, root.data);
        root.right = createBSTFromPreOrder(a, root.data, max);

        return root;
    }

    public Node createBSTFromPreOrder(int a[]) {
        return createBSTFromPreOrder(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String args[]) {
        ConstructBSTFromPreorder a = new ConstructBSTFromPreorder();
        int preorderArr[] = new int[]{43, 23, 29, 31, 41, 47, 53};
        Node root = a.createBSTFromPreOrder(preorderArr);
        a.inorder(root);
    }
}
