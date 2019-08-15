package com.bianchi.structure.queue;

public abstract class LinkedDataStructure<T extends Comparable<T>> {

    /**
     * The first element in the list.
     */
    public Node<T> head;

    /**
     * The current size of the list.
     */
    public int size = 0;
 
    public static class Node<T extends Comparable<T>> {

        /**
         * The next node
         */
        public Node<T> next;

        /**
         * Immutable Payload
         */
        final T payload;

        public T getPayload() {
            return payload;
        }

        public Node(T payload) {
            this.payload = payload;
        }
    }
}