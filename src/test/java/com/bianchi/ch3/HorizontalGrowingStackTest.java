package com.bianchi.ch3;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * HorizontalGrowingStackTest
 */
public class HorizontalGrowingStackTest {

    HorizontalGrowingStack<Integer> stack;

    @Before
    public void setupClass() {
        stack = new HorizontalGrowingStack(5);
    }

    
    @Test
    public void testPushWorksWithoutException() {
        for (int i = 0; i < 25; i++) {
            stack.push(1);
        }

        assertEquals((int) stack.stacksSize(), 5);
    }

    @Test
    public void testPopWorksWithoutException() {
        stack.push(1);
        assertEquals((int) stack.pop(), 1);
    }

    @Test
    public void testPopAtIndex() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(1);

        assertEquals((int) stack.popAt(0), 6);
    }

}