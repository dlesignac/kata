package fr.kata.lags;

public class RequestTree {

    private Node root;

    public RequestTree() {
        this.root = Node.createRoot();
    }

    public void insert(Request request) {
        this.root.insert(new Node(request));
    }

    public int maxGain() {
        return this.root.maxGain();
    }

    @Override
    public String toString() {
        return "RequestTree{" +
                "root=" + root +
                '}';
    }

}
