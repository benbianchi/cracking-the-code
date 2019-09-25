package com.bianchi.ch3;

import com.bianchi.structure.queue.Queue;

/**
 * This class allows us to have a concept of a minumum in the queue.
 */
public class StackWithMinimum extends Queue {

    private Comparable currentMinimum;

    @Override
    public void push(Comparable n) {
        size++;

        // If this is the smallest thing we have seen...
        if (currentMinimum == null || n.compareTo(this.currentMinimum) < 0) {
            this.currentMinimum = n;
        }

        Node newHead = new NodeWithMinumum(n, currentMinimum);

        newHead.next = head;

        this.head = newHead;
    }

    public static class NodeWithMinumum extends Node {

        Comparable min;

        Comparable payload;

        public NodeWithMinumum(Comparable payload, Comparable min) {
            super(payload);
            this.min = min;
        }

    }

    public Comparable getMin() {
        if (head == null) {
            return null;
        }

        return ((NodeWithMinumum) head).min;

    }

}