package com.basic.structure;

/**
 * 数组实现栈
 */
public class ArrayStack {
    Integer arr[];
    Integer size;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("the size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }

    // 查看即将弹出的数，但不弹出
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        // size比下标大一
        return arr[size - 1];
    }

    // 弹出
    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        return arr[--size];
    }

    // 放入
    public void push(int num) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("the stack is full");
        }
        arr[size++] = num;
    }
}
