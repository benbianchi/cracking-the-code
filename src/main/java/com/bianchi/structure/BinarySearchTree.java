package com.bianchi.structure;

import java.util.function.Function;

/**
 * This is a binary search tree!
 */
public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root;

    public BinarySearchTree() {}

    public void add(T n) {
        root = voidAddRecursively(root, n);
    }

    private Node<T> voidAddRecursively(Node<T> visitNode, T toBeAdded) {
        if (visitNode == null) {
            visitNode = new Node<T>(toBeAdded);
            return visitNode;
        }

        if (visitNode.value.compareTo(toBeAdded) > 0 ) {
            visitNode.left = voidAddRecursively(visitNode.left, toBeAdded);
        } else {
            visitNode.right = voidAddRecursively(visitNode.right, toBeAdded);
        }

        return visitNode;
    }

    public void inOrderTraversal(Function visitFunction, Node<T> current) {
        if (current == null) {
            return;
        }

        inOrderTraversal(visitFunction, current.left);
        visitFunction.apply(current);
        inOrderTraversal(visitFunction, current.right);        
    }

    public void preOrderTraversal(Function visitFunction, Node<T> current) {
        if (current == null) {
            return;
        }

        visitFunction.apply(current);
        preOrderTraversal(visitFunction, current.left);
        preOrderTraversal(visitFunction, current.right);        
    }

    public void postOrderTraversal(Function visitFunction, Node<T> current) {
        if (current == null) {
            return;
        }

        preOrderTraversal(visitFunction, current.left);
        preOrderTraversal(visitFunction, current.right);        
        visitFunction.apply(current);
    }


    public static class Node<T> {

        T value;

        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }
    }

    /**
     * Create a BST with minimum height
     * 
     * @param array The array we turn into a tree
     * @return the resulting tree.
     */
    public static BinarySearchTree createMinimalTree(Comparable[] array) {
        BinarySearchTree t = new BinarySearchTree();

        t.root = createMinimalTreeRecursively(array, 0, array.length - 1);

        return t;
    }

    /**
     * Recursively Algorithm we use to transform an array into a tree
     * @param array the array we are transforming
     * @param start our starting offset
     * @param end our ending offset
     * 
     * @return a node representing a piece of the tree.
     */
    private static Node createMinimalTreeRecursively(Comparable[] array, int start, int end) {

        if (end < start) {
            return null;
        }

        int midpoint = (start + end) / 2;

        Node n = new Node<>(array[midpoint]);

        n.left = createMinimalTreeRecursively(array, start, midpoint - 1);
        n.right = createMinimalTreeRecursively(array, midpoint + 1, end);
        
        return n;
    }

    /**
     * Get the nodes at a depth.
     * 
     * @param depth The desired depth we are querying for
     * @param tree The tree we are searching
     * @return a list of nodes at desired depth
     */
    public static LinkedList getNodesAtDepth(int depth, BinarySearchTree tree) {
        LinkedList collector = new LinkedList<>();

        getNodesAtDepth(0, depth, tree.root, collector);

        return collector;
    }

    /**
     * Recursively check nodes at depth
     * @param currentDepth The depth we are looking at
     * @param goalDepth The goal depth we are looking for
     * @param n the node we are currently looking at
     * @param collectingList The list of nodes we have already found.
     */
    private static void getNodesAtDepth(int currentDepth, int goalDepth, Node n, LinkedList collectingList) {

        if (n == null) {
            return;
        }

        if (currentDepth == goalDepth) {
            collectingList.add((Comparable) n.value);
            return;
        }

        getNodesAtDepth(currentDepth + 1, goalDepth, n.left, collectingList);
        getNodesAtDepth(currentDepth + 1, goalDepth, n.right, collectingList);
        
    }
}