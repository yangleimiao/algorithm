package com.basic.structure;

import java.util.Stack;

/**
 * 实现一个栈，放入、弹出的基本功能之外还要返回栈中最小元素，可以使用系统的栈结构实现
 * pop、push、getMin的时间复杂度为O(1)
 * 思路：
 * 建立两个栈，一个放数据，一个放最小值
 * 压入数据时，比较当前值与min栈中最小值，哪个小压入哪个min栈
 * 弹出时，数据弹出，min栈也弹出
 */
public class GetMinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public GetMinStack() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    // 压入数据
    public void push(int num) {
        // 如果min栈为空，直接压入
        if (minStack.isEmpty()) {
            minStack.push(num);
            // 如果num大于原来的最小值，则重复压入原来的最小值
        } else if (num > getMin()) {
            minStack.push(getMin());
            // 如果num小于原来的最小值，则压入num
        } else {
            minStack.push(num);
        }
        // data栈压入
        dataStack.push(num);
    }

    // 弹出
    public Integer pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        // Min栈中也弹出一个
        minStack.pop();
        return dataStack.pop();
    }

    // 获取最小值
    public Integer getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
