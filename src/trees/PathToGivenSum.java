package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathToGivenSum {
    static int totalPaths = 0;
    static class Node {
        int value;
        Node left, right;

        public Node(int val) {
            this.value = val;
        }
    }

    void findSum(Integer originalSum, Integer curSum, List<List<Integer>> result, List<Integer> currentList, Node node) {

        if (node == null) return;

        // choose a root
        Integer nodeValue = node.value;
        currentList.add(nodeValue);

        if (Objects.equals(curSum, nodeValue)) {
            List<Integer> resultL = new ArrayList(currentList);
            result.add(resultL);
            if(totalPaths < result.size()){
                totalPaths = result.size();
            }
        }

        // as the BST may contain negative values we have to iterate it all as root
        findSum(originalSum, originalSum, result, new ArrayList(), node.right);
        findSum(originalSum, originalSum, result, new ArrayList(), node.left);

        // with the current root find paths to sum left and right
        int remaining = curSum - nodeValue;

        findSum(originalSum, remaining, result, new ArrayList(currentList), node.left);
        findSum(originalSum, remaining, result, new ArrayList(currentList), node.right);

    }


    public static void main(String args[]) {
        PathToGivenSum p = new PathToGivenSum();
        List<List<Integer>> result = new ArrayList<>();
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(-1);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(2);
        root.right.right.right = new Node(6);


        p.findSum(5, 0, result, new ArrayList<>(), root);
        System.out.println(result);
        System.out.println(totalPaths);
    }
}
