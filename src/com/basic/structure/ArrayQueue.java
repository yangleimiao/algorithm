package com.basic.structure;

/**
 * 数组实现队列
 * start：表示出去一个数从哪个位置开始拿
 * end：表示进来一个数填到哪
 * size表示队列当前有多少个数
 * 通过size连接start和end：只要size不超过数组长度，end就可以一直循环放入数，
 * 只要size不为0，start就可以一直循环弹出数
 */
public class ArrayQueue {
    // 实现队列的数组
    Integer arr[];
    // 代表队列中有几个数，如果等于arr长度，则不能再放入数，如果等于0，则不能再弹出数
    Integer size;
    // start ：当前要取的数的下标
    Integer start;
    // end ：当前可以放数的位置的下标
    Integer end;

    // 初始化一个队列
    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("the init size less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }


    // 放入
    public void push(int num) {
        // 队列满了
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = num;
        // 如果end是数组的最后一个位置，则循环至数组第一个位置，如果不是，向下移
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    // 弹出
    public Integer poll() {
        //
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        // 队列中数少一个
        size--;
        int tmp = start;
        // start向下移动一位，如果start指向arr最后一个位置，则循环，指向第一个位置，如果不是，则向下移
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[tmp];
    }

    // 查看当前要弹出的数，但不弹出
    public Integer peek() {
        // 队列没有数
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

}
