package com.bianchi.structure.queue;

public abstract class Queue<T extends Comparable<T>> extends LinkedDataStructure<T> { 
    /**
     * Place an element within the stack.
     */
    abstract public void push(T n);

    /**
     * Read but do not consume the top node.
     * @return the top node's payload
     */
    public T peek() {
        return this.head.getPayload();
    }

    /**
     * Read and consume the top node.
     * @return the top node's payload
     */
    public T pop() {
        size--;
        Node n = this.head;
        this.head = this.head.next;

        return (T) n.getPayload();
    }


}