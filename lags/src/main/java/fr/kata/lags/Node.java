package fr.kata.lags;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static fr.kata.lags.Request.IS_AFTER;
import static fr.kata.lags.Request.IS_BEFORE;

public class Node implements Comparable<Node> {

    private Node parent;
    private Request value;
    private Set<Node> children;

    Node(Request value) {
        this.parent = null;
        this.value = value;
        this.children = ConcurrentHashMap.newKeySet();
    }

    int maxGain() {
        return value.getPrice() + childrenMaxGain();
    }

    int childrenMaxGain() {
        return children.stream()
                .map(Node::maxGain)
                .reduce(0, Integer::max);
    }

    boolean hasChild(Node node) {
        return children.contains(node);
    }

    boolean insert(Node nodeToInsert) {
        switch (nodeToInsert.value.compareTo(this.value)) {
            case IS_BEFORE:
                setParent(nodeToInsert);
                return true;
            case IS_AFTER:
                setChild(nodeToInsert);
                return true;
        }

        return false;
    }

    void setChild(Node nodeToInsert) {
        boolean isInserted = this.children.stream()
                .map(child -> child.insert(nodeToInsert))
                .reduce(false, Boolean::logicalOr);

        if (!isInserted) {
            nodeToInsert.parent = this;
            this.children.add(nodeToInsert);
        }
    }

    private void setParent(Node nodeToInsert) {
        nodeToInsert.parent = this.parent;
        nodeToInsert.children.add(this);
        this.parent.children.remove(this);
        this.parent.children.add(nodeToInsert);
    }

    @Override
    public int compareTo(Node o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", children=" + children +
                '}';
    }

    public static Node createRoot() {
        return new RootNode();
    }

    private static class RootNode extends Node {

        private RootNode() {
            super(null);
        }

        int maxGain() {
            return childrenMaxGain();
        }

        boolean insert(Node nodeToInsert) {
            setChild(nodeToInsert);
            return true;
        }

    }

}
