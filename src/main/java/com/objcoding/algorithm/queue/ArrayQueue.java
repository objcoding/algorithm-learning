package com.objcoding.algorithm.queue;

/**
 * 一个基于数组的顺序队列
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/10
 */

public class ArrayQueue {

    private int[] array;

    private int size;

    private int head;

    private int tail;

    public ArrayQueue(int size) {
        array = new int[size];
        this.size = size;
    }

    // 入队
    public boolean enqueue(int element) {
        if (tail == size) { // 队满
            if (head > 0) { // 队头有空位置
                int count = 0;
                // 数据向前迁移，看queue_3.jpg
                for (int i = head; i < tail; i++) {
                    array[count] = array[i];
                    count++;
                }
                tail -= head;
                head = 0;
            } else {
                return false;
            }
        }
        array[tail] = element;
        tail++;
        return true;
    }

    // 出队
    public int dequeue() {
        if (head == tail) { // 队空
            return -1;
        }
        int element = array[head];
        head++;
        return element;
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);

        System.out.println(2%8);

        arrayQueue.enqueue(0);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        arrayQueue.dequeue();
        arrayQueue.dequeue();

        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);

        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        arrayQueue.enqueue(7);
        arrayQueue.enqueue(8);


        return;
    }
}
