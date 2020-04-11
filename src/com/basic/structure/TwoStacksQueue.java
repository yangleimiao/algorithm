package com.basic.structure;

import java.util.Stack;

/**
 * 栈实现队列
 * 两个队列：push、pop
 * 压数时向push放
 * 弹出时从pop弹出
 * push需要在满足条件时向pop导数：
 * pop中如果有数，push不能向pop导数；如果pop为空，push中的数一次性倒完
 */
public class TwoStacksQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TwoStacksQueue(){
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    // 放入
    public void push(int num){
        pushStack.push(num);
    }

    // 弹出
    public Integer poll(){
        if (popStack.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        export();
        return popStack.pop();
    }


    public Integer peek(){
        if (popStack.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        export();
        return popStack.peek();
    }

    // 从push栈导入到pop栈
    // 导数的两个原则：
    // pop中如果有数，push不能向pop导数；如果pop为空，push中的数一次性倒完
    public void export(){
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
