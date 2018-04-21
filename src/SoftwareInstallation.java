import java.io.*;
import java.util.*;

class Graph {
    private Set<Node> softwares;

    Graph() {
        softwares = new LinkedHashSet<>();
    }

    public void addEdge(Node source, Node dest) {
        softwares.add(source);
        source.addNeighbour(dest);
    }
}

class Node {
    private int data;
    private boolean visited;
    private List<Node> neighbours;

    public Node(int data) {
        this.data = data;
        visited = false;
        neighbours = new ArrayList<>();
    }

    void addNeighbour(Node n) {
        this.neighbours.add(n);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }
}

interface ICommand {
    public void execute_command();
}

class DependCommand implements ICommand {

    @Override
    public void execute_command() {

    }
}

class CommandContext {
    private ICommand cmd_obj;

    void setCommand(ICommand strategy) {
        this.cmd_obj = strategy;
    }

    void execute() {
        cmd_obj.execute_command();
    }
}

public class SoftwareInstallation {
    Graph dependencyGraph = new Graph();

    public static void main(String arg[]) throws IOException {
        File f = new File("src/input.txt");
        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine;
        while ((readLine = b.readLine()) != null) {
            String cmdLine[] = readLine.split("\\s+");
            String cmd = cmdLine[0];
            CommandContext ct = new CommandContext();
            switch (cmd) {
                case "DEPEND":
                    ct.setCommand(new DependCommand());
                    ct.execute();
                    break;
                case "INSTALL":
                    break;
                case "REMOVE":
                    break;
                case "LIST":
                    break;
                case "END":
                    break;
            }
        }
    }
}
