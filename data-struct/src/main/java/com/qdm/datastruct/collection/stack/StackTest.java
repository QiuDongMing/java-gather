package com.qdm.datastruct.collection.stack;

import org.junit.Test;

import java.util.Stack;

public class StackTest {

    @Test
    public void stackTest1() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Integer peek = stack.peek();
        System.out.println("peek = " + peek);
        System.out.println("stack = " + stack);
        stack.pop();
        System.out.println("stack = " + stack);




    }





}
