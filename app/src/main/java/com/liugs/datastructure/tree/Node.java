package com.liugs.datastructure.tree;

public class Node {
    public Node parent;
    public int data;
    public Node leftChild;
    public Node rightChild;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}
