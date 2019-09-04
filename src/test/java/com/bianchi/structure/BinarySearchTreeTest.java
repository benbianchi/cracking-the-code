package com.bianchi.structure;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.bianchi.structure.BinarySearchTree.Node;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest {

    static BinarySearchTree<Integer> tree = new BinarySearchTree<>();

    static class CollectorFunction implements Function<Node, Void> {

            List<Comparable> asList = new ArrayList<>();

            public List<Comparable> getList() {
                return asList;
            }

            @Override
            public Void apply(Node node) {
                asList.add((Comparable) node.value);
                return null;
            }
        };

    CollectorFunction collectorFunction = new CollectorFunction();        

    @BeforeClass
    public static void setup() {
        tree.add(1);
        tree.add(0);
        tree.add(3);
        tree.add(5);
        tree.add(4);
    }

    @Test
    public void binarySearchTreeWorks() {
        assertEquals( (int) tree.root.value, 1);
        assertEquals( (int) tree.root.getLeft().value, 0);

        assertEquals( (int) tree.root.getRight().getRight().value, 5);
        assertEquals( (int) tree.root.getRight().getRight().getLeft().value, 4);
        assertEquals( (int) tree.root.getRight().value, 3);
    }

    @Test
    public void testInOrderTraversal () {
        tree.inOrderTraversal(collectorFunction, tree.root);
        Integer[] asArray = collectorFunction.getList().toArray(new Integer[collectorFunction.getList().size()]);
        Integer[] expectedArray = {0, 1, 3, 4 ,5};
        assertArrayEquals(asArray, expectedArray);
    }

    @Test
    public void preOrderTraversal () {
        tree.preOrderTraversal(collectorFunction, tree.root);
        Integer[] asArray = collectorFunction.getList().toArray(new Integer[collectorFunction.getList().size()]);
        Integer[] expectedArray = {1, 0, 3, 5 ,4};
        assertArrayEquals(asArray, expectedArray);
    }

    @Test
    public void postOrderTraversal () {
        tree.postOrderTraversal(collectorFunction, tree.root);
        Integer[] asArray = collectorFunction.getList().toArray(new Integer[collectorFunction.getList().size()]);
        Integer[] expectedArray = {0, 3, 5, 4 ,1};
        assertArrayEquals(asArray, expectedArray);
    }

}