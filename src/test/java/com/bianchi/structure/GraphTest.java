package com.bianchi.structure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest {

    @Test
    public void graphsCanHaveChildren() {

        Graph.Node node = new Graph.Node(
            Pair.from(0, new Graph.Node()),
            Pair.from(0, new Graph.Node()
            )
        );
        Graph  graph = new Graph();
        graph.add(node);
        assertEquals(graph.allNodes.size(), 1);
        assertEquals(graph.allNodes.get(0).children.size(), 2);
    }
}