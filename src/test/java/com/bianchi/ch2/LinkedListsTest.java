package com.bianchi.ch2;

import static org.junit.Assert.*;

import com.bianchi.structure.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListsTest {

    LinkedList<Integer> list;

    @Before
    public void setup() {
        list = new LinkedList<Integer>();
    }

    @Test
    public void testLinkList() {
       assertNotNull(list);
       assertEquals(list.size, 0);

       list.add(10);
       assertEquals(list.size, 1);
    }

    @Test
    public void testRemoveDuplicatesFromList() {
        assertNotNull(list);

        list.add(20);
        list.add(20);

        LinkedListsQuestions.removeDuplicates(list);

        assertEquals(list.size, 1);
        assertEquals(list.get(0), 20);
        
    }

    @Test
    public void testGetKthLast() {
        assertNotNull(list);
        LinkedListsQuestions.getKthToLastOnNode(list.head, 0);
    }

    @Test
    public void testPartitionList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(1);

        LinkedList partitionedList = LinkedListsQuestions.partition(linkedList, 5);

        assertEquals(3, partitionedList.get(0));
        assertEquals(2, partitionedList.get(1));
        assertEquals(1, partitionedList.get(2));
        assertEquals(5, partitionedList.get(3));
        assertEquals(8, partitionedList.get(4));
        assertEquals(5, partitionedList.get(5));
        assertEquals(10, partitionedList.get(6));
    }

    @Test
    public void testSumList() {

        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();

        l1.add(7);
        l1.add(1);
        l1.add(6);

        l2.add(5);
        l2.add(9);
        l2.add(2);

        LinkedList<Integer> result = sumLists(l1, l2);
    }
}
