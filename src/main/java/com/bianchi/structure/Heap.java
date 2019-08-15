package com.bianchi.structure;

import java.lang.Comparable;


/**
 *
 *
 * 
 */
public class Heap<T extends Comparable> {

    private T[] array; 

    public Heap(T[] array) {
        this.array = array;
    }

    // A[(2*n)+1] and A[(2*n)+2].
    // getLeft

    /**
     * Get the left child of the offset
     *
     * @param offset the offset we are looking for's left child.
     */
    protected T getLeftChild(Integer offset) {
        return array[2 * offset + 1];
    }

    /**
     * Get the right child of the offset
     *
     * @param offset the offset we are looking for's right child.
     */
    protected T getRightChild(Integer offset) {
        return array[2 * offset + 2];
    }

    public T[] toArray() {
        return this.array;
    }
    // getRight
    // getParent

}