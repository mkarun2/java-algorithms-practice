package trees;

public class FromPreorder {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static int index;

    public Node contructFromPreorder(int arr[], int key, int min, int max) {
        if (index >= arr.length) {
            return null;
        }
        Node root = null;
        if (key > min && key < max) {
            root = new Node(key);
            index++;
            if (index < arr.length) {
                root.left = contructFromPreorder(arr, arr[index], min, root.val);
                root.right = contructFromPreorder(arr, arr[index], root.val, max);
            }
        }
        return root;
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void main(String argsp[]) {
        FromPreorder fp = new FromPreorder();
        int a[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = fp.contructFromPreorder(a, a[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        fp.inorder(root);
    }
}
