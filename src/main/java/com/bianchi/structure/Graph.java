package com.bianchi.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * A Graph implemented in Java
 */

public class Graph {

    List<Node> allNodes = new ArrayList<Node>();

    public Graph() {

    }

    public void add(Node n) {
        allNodes.add(n);
    }

    public static class Node {
        List<Pair<Integer, Node>> children = null;

        Object payload;

        public boolean visitted = false;

        public Node(Object payload) {
            this.payload = payload;
            children = new ArrayList<Pair<Integer, Node>>();
        }

        public Node(Object payload, Pair<Integer, Node>... otherNodes) {
            this.payload = payload;
            children = Arrays.stream(otherNodes).collect(Collectors.toList());
        }

        public void add(Pair<Integer, Node> n) {
            this.children.add(n);
        }

        public void add(Pair<Integer, Node>... otherNodes) {
            children.addAll(Arrays.stream(otherNodes).collect(Collectors.toList()));
        }
    }

    public boolean performDepthFirstSearch(Node beginning, Node destination) {
        beginning.visitted = true;
        if (beginning == destination) {
            return true;
        }

        for (Pair<Integer, Node> childPair : beginning.children) {
            Node n = childPair.getValue();

            if (!n.visitted && performDepthFirstSearch(n, destination)) {
                return true;
            }
        }

        return false;
    }

    public boolean performBreadthFirstSearch(Node beginning, Node destination) {
        Queue<Node> queue = new java.util.LinkedList<>();
        beginning.visitted = true;

        queue.add(beginning);

        while (queue.peek() != null) {
            Node current = (Node) queue.poll();
            if (current == destination) {
                return true;
            }

            for (Pair<Integer, Node> pair : current.children) {
                if (pair.getValue().visitted == false) {
                    pair.getValue().visitted = true;
                    queue.add(pair.getValue());
                }
            }
        }

        return false;
    }

}