package com.objcoding.algorithm.queue;

/**
 * 一个基于数组的循环队列
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/10
 */
public class CycleArrayQueue {

    private int[] array;

    private int size;

    private int head;

    private int tail;

    public CycleArrayQueue(int size) {
        array = new int[size];
        this.size = size;
    }

    // 入队
    public boolean enqueue(int element) {
        /**
         * 把一个顺序队列扳成一个甜甜圈，如图queue_5.jpg，
         * 你会发现队列满了的时候，tail会紧跟着head，
         * 这时用 % 符号可以在圈内循环
         */
        if ((tail + 1) % size == head) { // 队满
            return false;
        }
        array[tail] = element;
        tail = (tail + 1) % size;
        return true;
    }

    // 出队
    public int dequeue() {
        if (tail == head) { // 队空
            return -1;
        }
        int element = array[head];
        head = (head + 1) % size;
        return element;
    }

}
