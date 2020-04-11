package com.basic.structure;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueuesStack {
    /**
     * 用队列实现栈
     *
     */

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueuesStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    // 压入数据
    public void push(int num){
        queue.add(num);
    }

    // 弹出数据
    public Integer pop(){
        if (queue.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        // 如果queue中有多个数据，queue弹出的放到help中，直到只剩一个
        while (queue.size() != 1){
            help.add(queue.poll());
        }
        return queue.poll();
    }

    // 查看即将弹出的数据
    // peek 需要取到queue顶部的（最后一个被压入的）
    // 先将queue中队底的压入到help，只剩下一个就是需要返回的数据
    // 这一个也需要再放到help中
    // 此时help中有所有数据，queue为空
    // 然后交换引用，help成为queue
    public Integer peek(){
        if (queue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while (queue.size() != 1){
            help.add(queue.poll());
        }
        int res = queue.peek();
        help.add(res);
        swap();
        return res;
    }

    // 交换引用
    public void swap(){
        Queue<Integer> tmp;
        tmp = queue;
        queue = help;
        help = tmp;
    }

}
