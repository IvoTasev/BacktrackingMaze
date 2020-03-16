package Assignment_3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static final int size = 23;
    public static ArrayList<Node> nodes = new ArrayList<>();
    public static Node firstNode;
    public static Node secondNode;

    public static void main(String[] args) {
        new Main().init();
    }

    public void init() {
        ArrayList<State> visited = new ArrayList<>();
        createMaze();
        print();
        System.out.println("Sequence of states: " + solve(new State(firstNode, secondNode), visited));
    }

    public void print() {
        System.out.println("Representation of the maze: ");
        for (int i = 0; i < size; i++) {
            System.out.print(nodes.get(i) + "--> ");
            for (int j = 0; j < nodes.get(i).getPointers().size(); j++) {
                System.out.print(nodes.get(i).getPointers().get(j).getColor() + " --> ");
                System.out.print(nodes.get(i).getPointers().get(j).getTarget() + " ");

            }
            System.out.println();
        }
        System.out.println();
    }

    //Hardcoded maze to represent the one from the assignment
    public void createMaze() {
        firstNode = new Node(Node.colors.PURPLE);
        secondNode = new Node(Node.colors.BLACK);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.ORANGE);
        new Node(Node.colors.ORANGE);
        new Node(Node.colors.PURPLE);
        new Node(Node.colors.PURPLE);
        new Node(Node.colors.BLACK);
        new Node(Node.colors.ORANGE);
        new Node(Node.colors.PURPLE);
        new Node(Node.colors.ORANGE);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.ORANGE);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.BLACK);
        new Node(Node.colors.ORANGE);
        new Node(Node.colors.GREEN);
        new Node(Node.colors.BLACK);
        new Node(Node.colors.BLACK);
        new Node(Node.colors.GREEN).setFinish(true);

        nodes.get(0).getPointers().add(new Pointer(nodes.get(3), Node.colors.PURPLE));
        nodes.get(0).getPointers().add(new Pointer(nodes.get(4), Node.colors.BLACK));
        nodes.get(1).getPointers().add(new Pointer(nodes.get(5), Node.colors.GREEN));
        nodes.get(1).getPointers().add(new Pointer(nodes.get(11), Node.colors.PURPLE));
        nodes.get(2).getPointers().add(new Pointer(nodes.get(0), Node.colors.ORANGE));
        nodes.get(2).getPointers().add(new Pointer(nodes.get(3), Node.colors.ORANGE));
        nodes.get(3).getPointers().add(new Pointer(nodes.get(12), Node.colors.BLACK));
        nodes.get(4).getPointers().add(new Pointer(nodes.get(8), Node.colors.ORANGE));
        nodes.get(5).getPointers().add(new Pointer(nodes.get(8), Node.colors.GREEN));
        nodes.get(5).getPointers().add(new Pointer(nodes.get(9), Node.colors.PURPLE));
        nodes.get(6).getPointers().add(new Pointer(nodes.get(1), Node.colors.GREEN));
        nodes.get(7).getPointers().add(new Pointer(nodes.get(2), Node.colors.PURPLE));
        nodes.get(8).getPointers().add(new Pointer(nodes.get(13), Node.colors.BLACK));
        nodes.get(8).getPointers().add(new Pointer(nodes.get(3), Node.colors.GREEN));
        nodes.get(9).getPointers().add(new Pointer(nodes.get(14), Node.colors.GREEN));
        nodes.get(10).getPointers().add(new Pointer(nodes.get(9), Node.colors.PURPLE));
        nodes.get(10).getPointers().add(new Pointer(nodes.get(11), Node.colors.GREEN));
        nodes.get(11).getPointers().add(new Pointer(nodes.get(6), Node.colors.GREEN));
        nodes.get(12).getPointers().add(new Pointer(nodes.get(7), Node.colors.GREEN));
        nodes.get(12).getPointers().add(new Pointer(nodes.get(17), Node.colors.GREEN));
        nodes.get(13).getPointers().add(new Pointer(nodes.get(19), Node.colors.ORANGE));
        nodes.get(13).getPointers().add(new Pointer(nodes.get(22), Node.colors.GREEN));
        nodes.get(14).getPointers().add(new Pointer(nodes.get(22), Node.colors.PURPLE));
        nodes.get(14).getPointers().add(new Pointer(nodes.get(21), Node.colors.GREEN));
        nodes.get(15).getPointers().add(new Pointer(nodes.get(14), Node.colors.GREEN));
        nodes.get(16).getPointers().add(new Pointer(nodes.get(10), Node.colors.BLACK));
        nodes.get(16).getPointers().add(new Pointer(nodes.get(15), Node.colors.BLACK));
        nodes.get(16).getPointers().add(new Pointer(nodes.get(11), Node.colors.PURPLE));
        nodes.get(17).getPointers().add(new Pointer(nodes.get(8), Node.colors.ORANGE));
        nodes.get(17).getPointers().add(new Pointer(nodes.get(19), Node.colors.ORANGE));
        nodes.get(18).getPointers().add(new Pointer(nodes.get(17), Node.colors.GREEN));
        nodes.get(19).getPointers().add(new Pointer(nodes.get(18), Node.colors.BLACK));
        nodes.get(19).getPointers().add(new Pointer(nodes.get(20), Node.colors.ORANGE));
        nodes.get(20).getPointers().add(new Pointer(nodes.get(22), Node.colors.BLACK));
        nodes.get(20).getPointers().add(new Pointer(nodes.get(21), Node.colors.ORANGE));
        nodes.get(21).getPointers().add(new Pointer(nodes.get(16), Node.colors.ORANGE));
    }

    public LinkedList<State> solve(State state, ArrayList<State> visited) {
        LinkedList<State> solution = new LinkedList<>();
        visited.add(state);

        if (state.isFinal()) {
            solution.add(state);
            System.out.println("FINISH!");
        } else {
            if (!state.getPossibleStates().isEmpty()) {
                for (State s : state.getPossibleStates()) {
                    if (!visited.contains(s)) {
                        System.out.println(s);
                        solution = (solve(new State(s.getPawn1(), s.getPawn2()), visited));
                        if (!solution.isEmpty()) {
                            solution.addFirst(s);
                            return solution;
                        } else {
                            System.out.println("going back " + s);
                        }
                    }
                }
            }
        }
        return solution;
    }
}
