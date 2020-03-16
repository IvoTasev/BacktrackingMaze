package src;

import java.util.ArrayList;

public class State {
    private Node pawn1;
    private Node pawn2;

    public State(Node pawn1, Node pawn2){
        this.pawn1 = pawn1;
        this.pawn2 = pawn2;
    }

    public Node getPawn1() {
        return pawn1;
    }

    public Node getPawn2() {
        return pawn2;
    }

    public boolean isFinal(){
        return (pawn1.isFinish() || pawn2.isFinish());
     }

     public ArrayList<Node> getTargetsForNode(Node node){
        ArrayList<Node> nodes = new ArrayList<>();
        Node opposite;
        if (node == getPawn1()) {
            opposite = getPawn2();
        } else opposite = getPawn1();

        for (Pointer pointer : node.getPointers()){
            if (pointer.getColor() == opposite.getColor()){
                nodes.add(pointer.getTarget());
            }
        }
        return nodes;
     }

     public ArrayList<State> getPossibleStates(){
         ArrayList<State> states = new ArrayList<>();


         for (Node target : getTargetsForNode(getPawn1())){
             states.add(new State(target, getPawn2()));
         }
         for (Node target : getTargetsForNode(getPawn2())){
             states.add(new State(getPawn1(), target));
         }
        return states;
     }

    @Override
    public String toString() {
        return "(" + pawn1 + ", " + pawn2 + ")";
    }
}
