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
}