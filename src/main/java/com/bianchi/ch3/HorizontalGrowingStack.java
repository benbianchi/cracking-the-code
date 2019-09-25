package com.bianchi.ch3;

import java.util.ArrayList;
import java.util.List;

import com.bianchi.structure.queue.FIFO;
import com.bianchi.structure.queue.Queue;

/**
 * HorizontalGrowingStack
 */
public class HorizontalGrowingStack<T extends Comparable<T>> {

    /**
     * This will grow.
     */
    private final List<Queue<T>> allStacks;

    private Queue<T> currentStack;

    private final int maxCapacity;

    public HorizontalGrowingStack(int maxCapacity) {
        if (maxCapacity == 0) {
            throw new IllegalStateException("Cannot have Horizontal Growing Stack with Max Capacity of 0.");
        }

        this.maxCapacity = maxCapacity;

        this.currentStack = new FIFO<T>();
        this.allStacks = new ArrayList<Queue<T>>();
        this.allStacks.add(this.currentStack);
    }

    /**
     * Here we want to add to the stack, but we may have to add a new stack to our
     * current set of stacks
     * @param value the value we are adding.
     */
    void push(T value) {
        if (currentStack.size > maxCapacity) {
            currentStack = new FIFO<T>();
            allStacks.add(currentStack);
        }

        currentStack.push(value);
    }
    
    /**
     * Remove an element from the set of stacks
     */
    public T pop() {

        if (allStacks.size() == 0) {
            throw new IllegalStateException("Nothing in this thing!");
        }

        if (currentStack.size == 0) {
            Integer index = allStacks.indexOf(currentStack);

            currentStack = allStacks.get( index - 1 );
            allStacks.remove(index);
        }

        return currentStack.pop();
    }

    /**
     * Remove from the stack at a given point!
     */
    public T popAt(int index)  {
        if (allStacks.size() < index) {
            throw new IllegalStateException("Accessing not a real stack.");
        }

        return allStacks.get(index).pop();
    }

    public Integer stacksSize() {
        return allStacks.size();
    }
}