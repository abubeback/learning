package com.abu.algo.common.search;

public class Node{
    int x;
    int y;
    Node parent;
    int step;

    public Node(){}

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    Node(int x, int y, int step, Node parent){
        this.x = x;
        this.y = y;
        this.step = step;
        this.parent = parent;
    }
}