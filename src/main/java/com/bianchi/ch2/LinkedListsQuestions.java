package com.bianchi.ch2;

import java.util.HashSet;

import com.bianchi.structure.LinkedList;

public class LinkedListsQuestions {

    public static LinkedList removeDuplicates(LinkedList l) {

        HashSet<Comparable> set = new HashSet<>();

        for (int i = 0; i < l.size; i++) {

            Comparable c = l.get(i);

            if (set.contains(c)) {
                l.delete(i);
                l.size--;
            } else {
                set.add(c);
            }
        }

        return l;
    }

    public static Integer getKthToLastOnNode(LinkedList.Node n, Integer k) {
        if (n == null) {
            return 0;
        }

        int i = 1 + getKthToLastOnNode(n.next, k);

        if (i == k) {
            System.out.println("Found the node");
        }

        return i;

    }

    public static LinkedList partition(LinkedList listToBePartitioned, Comparable pivotPoint) {
        LinkedList lowerPartitionList = new LinkedList();
        LinkedList upperPartitionList = new LinkedList();

        LinkedList.Node current = listToBePartitioned.head;

        while (current != null) {
            if (current.getPayload().compareTo(pivotPoint) == -1) {
                lowerPartitionList.add(current.getPayload());
            } else {
                upperPartitionList.add(current.getPayload());
            }

            current = current.next;

        }
        lowerPartitionList.appendList(upperPartitionList);

        return lowerPartitionList;

    }

	public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        
        LinkedList output = new LinkedList<Integer>();

        return output;
	}
}