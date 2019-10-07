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
    
    @Test
    public void testCreateMinimalTree () {
        Integer[] inputArray = { 1, 2, 3, 4, 5, 6, 7 };

        BinarySearchTree<Integer> minimalTree = BinarySearchTree.createMinimalTree(inputArray);
 
        assertEquals((int) minimalTree.root.value, 4);

        assertEquals((int) minimalTree.root.left.value, 2);
        assertEquals((int) minimalTree.root.left.left.value, 1);
        assertEquals((int) minimalTree.root.left.right.value, 3);

        assertEquals((int) minimalTree.root.right.value, 6);
        assertEquals((int) minimalTree.root.right.right.value, 7);
        assertEquals((int) minimalTree.root.right.left.value, 5);
    }

    @Test
    public void testGetAllNodesAtDepth() {
        assertEquals(BinarySearchTree.getNodesAtDepth(0, tree).get(0), (int) 1);

        assertEquals(BinarySearchTree.getNodesAtDepth(1, tree).get(1), (int) 3);
        assertEquals(BinarySearchTree.getNodesAtDepth(1, tree).get(0), (int) 0);
        
        assertEquals(BinarySearchTree.getNodesAtDepth(2, tree).get(0), (int) 5);
        
        assertEquals(BinarySearchTree.getNodesAtDepth(3, tree).get(0), (int) 4);
    }
    
}