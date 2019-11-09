package com.bianchi.structure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {

    static Graph graph = new Graph();

    static Graph.Node destination = new Graph.Node(7);
    static Graph.Node root;

    @BeforeClass
    public static void setUp() {
        Graph.Node route1 = new Graph.Node(4, Pair.from(0, destination));
        Graph.Node route2 = new Graph.Node(6, Pair.from(0, destination));

        root = new Graph.Node( 0,
            Pair.from(0, new Graph.Node(1)),
            Pair.from(0, new Graph.Node(2)),
            Pair.from(0, new Graph.Node(3)),
            Pair.from(0, new Graph.Node(5, Pair.from(0, route2))),
            Pair.from(0, route1),
            Pair.from(0, new Graph.Node(2))
            );
        graph.add(root);
    }

    @Test
    public void depthFirstSearchWorks() {
        Boolean dfs = graph.performDepthFirstSearch(root, destination);

        assertTrue(dfs);
    }

    @Test
    public void breadthFirstSearchWorks() {
        Boolean bfs = graph.performBreadthFirstSearch(root, destination);

        assertTrue(bfs);
    }


}
