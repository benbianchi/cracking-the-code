package com.bianchi.structure.queue;

/**
 * A first in, first out queue
 */
public class FIFO<T extends Comparable<T>> extends Queue {
   
    /**
     * Place an element within the stack.
     * 
     * @param payload the element to put into stack.
     */
    @Override
    public void push(Comparable payload) {
        size++;
        Node previousHead = this.head;

        this.head = new Node<>(payload);

        this.head.next = previousHead;
    }
}