package Assignment_3;

import java.util.ArrayList;

public class Node {
    enum colors {BLACK, PURPLE, ORANGE, GREEN}

    private boolean finish = false;
    private colors color;
    private String name;
    private ArrayList<Pointer> pointsTo;

    public Node(colors color){
        this.name = String.valueOf(Main.nodes.size()+1);
        this.color = color;
        pointsTo = new ArrayList<>();
        Main.nodes.add(this);
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public ArrayList<Pointer> getPointers(){
        return pointsTo;
    }
    public colors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color + " "  + this.name;
    }
}
