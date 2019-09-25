package com.bianchi.ch3;

import static org.junit.Assert.assertEquals;

import com.bianchi.structure.queue.FIFO;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * SortedStackTest
 */
public class SortedStackTest {

    static FIFO<Integer> stack = new FIFO<>();

    @BeforeClass
    public static void setupStack() {
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
    }

    /**
     * Sort a stack
     */
    public static FIFO sortStack(FIFO<Integer> f) {

        FIFO<Integer> tempStack = new FIFO<>();

        while (f.size > 0) {
            Integer temp = (Integer) f.pop();

            while (tempStack.size != 0 && ((Integer) tempStack.peek()) > temp) {
                f.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }


    @Test
    public void testItWorks() {
        FIFO result = sortStack(stack);

        assertEquals((int) result.pop(), 98);
        assertEquals((int) result.pop(), 92);
        assertEquals((int) result.pop(), 34);
        assertEquals((int) result.pop(), 31);
        assertEquals((int) result.pop(), 23);
        assertEquals((int) result.pop(), 3);
    }
}