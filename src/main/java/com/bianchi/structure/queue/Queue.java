package com.bianchi.structure.queue;

public abstract class Queue<T extends Comparable<T>> extends LinkedDataStructure<T> { 
    /**
     * Place an element within the stack.
     */
    abstract void push(Node n);

    /**
     * Read but do not consume the top node.
     * @return the top node's payload
     */
    Comparable peek() {
        return this.head.getPayload();
    }

    /**
     * Read and consume the top node.
     * @return the top node's payload
     */
    Comparable pop() {
        Node n = this.head;
        this.head = this.head.next;

        return n.getPayload();
    }


}