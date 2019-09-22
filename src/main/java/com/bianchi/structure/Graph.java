package com.bianchi.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        
        public Node() {
            children = new ArrayList<Pair<Integer,Node>>();
        }

        public Node(Pair<Integer, Node>... otherNodes) {
            children = Arrays.stream(otherNodes).collect(Collectors.toList());
        }

        public void add(Pair<Integer, Node> n) {
            this.children.add(n);
        }

        public void add(Pair<Integer, Node>... otherNodes) {
            children.addAll(Arrays.stream(otherNodes).collect(Collectors.toList()));
        }
    } 
 }