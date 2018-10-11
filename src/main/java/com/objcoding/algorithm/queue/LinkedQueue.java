package com.objcoding.algorithm.queue;

/**
 * 一个基于链表的链式队列
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/10
 */
public class LinkedQueue {

    private Node head = null;
    private Node tail = null;

    private static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean enqueue(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    public int dequeue() {
        if (head == null) {
            return -1;
        }
        Node node = head.next;
        int value = node.value;
        head = node;
        return value;
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();

        linkedQueue.enqueue(0);
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        linkedQueue.enqueue(5);

        linkedQueue.dequeue();
        linkedQueue.dequeue();
        linkedQueue.dequeue();
        linkedQueue.dequeue();

        linkedQueue.enqueue(6);
        linkedQueue.enqueue(7);
    }

}
