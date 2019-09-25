package com.bianchi.ch3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackWithMinimumTest {
    
    @Test
    public void testWorksLikeDescribed() {

        StackWithMinimum stack = new StackWithMinimum();

        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(20);

        assertEquals(stack.getMin(), 8);
        stack.pop();
        assertEquals(stack.getMin(), 8);
        stack.pop();
        assertEquals(stack.getMin(), 9);
        stack.pop();
        assertEquals(stack.getMin(), 10);
    }
}