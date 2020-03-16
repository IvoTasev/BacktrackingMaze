package src;

public class Pointer {
    private Node.colors color;
    private Node target;

    public Pointer(Node target, Node.colors color){
        this.color = color;
        this.target = target;
    }

    public Node.colors getColor() {
        return color;
    }

    public Node getTarget() {
        return target;
    }
}
