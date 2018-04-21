package sort;

import java.util.*;

public class TopoSort {
    Stack<Node> stack = new Stack<>();

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        public Node(int data) {
            this.data = data;
            visited = false;
            neighbours = new ArrayList<>();
        }

        public void addNeighbour(Node n) {
            this.neighbours.add(n);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }
    }

    static class Graph {
        private Set<Node> vertices;

        public Graph() {
            vertices = new LinkedHashSet<>();
        }

        public void addEdge(Node source, Node dest) {
            vertices.add(source);
            source.addNeighbour(dest);
        }
    }

    public void toplogicalSort(Node node) {
        List<Node> neighbours = node.getNeighbours();
        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                toplogicalSort(n);
                n.visited = true;
            }
        }
        stack.push(node);
    }

    public void printStack(){
        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop().data + " ");
    }

    public static void main(String arg[]) {

        TopoSort topological = new TopoSort();
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        Graph g = new Graph();
        g.addEdge(node40, node10);
        g.addEdge(node40, node20);
        g.addEdge(node10, node30);
        g.addEdge(node20, node10);
        g.addEdge(node20, node30);
        g.addEdge(node20, node60);
        g.addEdge(node20, node50);
        g.addEdge(node30, node60);
        g.addEdge(node60, node70);
        g.addEdge(node50, node70);

        System.out.println("Topological Sorting Order:");
        topological.toplogicalSort(node40);
        topological.printStack();
    }
}