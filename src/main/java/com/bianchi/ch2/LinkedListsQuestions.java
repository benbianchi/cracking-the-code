package com.bianchi.ch2;

import java.util.HashSet;
import com.bianchi.structure.LinkedList;
import com.bianchi.structure.queue.FIFO;
import com.bianchi.structure.queue.LinkedDataStructure.Node;

public class LinkedListsQuestions {

    public static LinkedList removeDuplicates(LinkedList l) {

        int newSize = l.size;
        HashSet<Comparable> set = new HashSet<>();

        for (int i = 0; i < l.size; i++) {

            Comparable c = l.get(i);

            if (set.contains(c)) {
                l.delete(i);
                newSize--;
            } else {
                set.add(c);
            }
        }

        l.size = newSize;

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

	public static LinkedList<Integer> sumLists(Node<Integer> n1, Node<Integer> n2, int carry) {        
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int value = carry;

        if (n1.getPayload() != null) {
            value += n1.getPayload();            
        }
        
         if (n2.getPayload() != null) {
            value += n2.getPayload();            
        }

        Node result = new Node(value % 10);
        
        return null;
    }

	public static boolean isPalindrome(LinkedList<Integer> l1) {
		Node slow = l1.head;
        Node fast = l1.head;

        FIFO<Integer> queue = new FIFO<>();
        
        
        while (fast != null && fast.next != null) {
            queue.push(slow.getPayload());
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.getPayload() != queue.pop()) {
                return false;
            }

            slow = slow.next;
        }

        return true;
	}

	public static Object getIntersectionNode(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        
        LinkedList longer = l1.size >= l2.size ? l1 : l2;
        LinkedList shorter = l1.size > l2.size ? l2 : l1;

        while( longer.size > shorter.size) {
            longer.delete(0);
        }
        
        while (longer.head != null) {

            if (longer.head == shorter.head) {
                return longer.head;
            }

            longer.delete(0);
            shorter.delete(0);
        }

        return null;
	}
    
    public static Node getCyclicalNode(LinkedList<Integer> l1) {

        Node fast = l1.head;
        Node slow = l1.head;

        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        slow = l1.head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}