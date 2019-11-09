package com.bianchi.structure;

import java.util.Queue;

import com.bianchi.structure.queue.LinkedDataStructure;

/**
 * A custom written linked list class.
 */
public class LinkedList<T extends Comparable<T>> extends LinkedDataStructure<T> implements Queue {


    public LinkedList(T head) {
        this.head = new Node<T>(head);
    }

    public LinkedList() {
    }


    /**
     * Add a node to the end of the list.
     * 
     * @param payload
     */
    public void add(T payload) {
        addNode(new Node<T>(payload));
    }

    /**
     * Implemented to only expose the fact that we can intersect..
     */
    public void addNode(Node<T> node) {
        size++;

        if (head  == null){
            head = node;
            return;
        }
        
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = node;
    }

	public Node getNode(int indexWeAreSearchingFor) {
        
        Node current = head;

        for (int i = 0; i < indexWeAreSearchingFor; i++) {
            current = current.next;
        }

        return current;
	}

    public Comparable get(int indexWeAreSearchingFor) {
        return getNode(indexWeAreSearchingFor).getPayload();
	}

	public void delete(int indexWeAreDeleting) {
        size--;
        if (indexWeAreDeleting == 0) {
            this.head = head.next;
            return;
        }

        Node current = head;

        for (int i = 0; i < indexWeAreDeleting - 1; i++) {
            current = current.next;
        }

        Node newNext = current.next.next;
        current.next = newNext;
    }
    
    public void appendList(LinkedList l) {
        Node tail = getNode(size - 1);
        tail.next  = l.head;
    }
}